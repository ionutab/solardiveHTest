package solardivehtest



import grails.test.mixin.*
import spock.lang.*

@TestFor(MandarineController)
@Mock(Mandarine)
class MandarineControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.mandarineInstanceList
            model.mandarineInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.mandarineInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def mandarine = new Mandarine()
            mandarine.validate()
            controller.save(mandarine)

        then:"The create view is rendered again with the correct model"
            model.mandarineInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            mandarine = new Mandarine(params)

            controller.save(mandarine)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/mandarine/show/1'
            controller.flash.message != null
            Mandarine.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def mandarine = new Mandarine(params)
            controller.show(mandarine)

        then:"A model is populated containing the domain instance"
            model.mandarineInstance == mandarine
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def mandarine = new Mandarine(params)
            controller.edit(mandarine)

        then:"A model is populated containing the domain instance"
            model.mandarineInstance == mandarine
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/mandarine/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def mandarine = new Mandarine()
            mandarine.validate()
            controller.update(mandarine)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.mandarineInstance == mandarine

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            mandarine = new Mandarine(params).save(flush: true)
            controller.update(mandarine)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/mandarine/show/$mandarine.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/mandarine/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def mandarine = new Mandarine(params).save(flush: true)

        then:"It exists"
            Mandarine.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(mandarine)

        then:"The instance is deleted"
            Mandarine.count() == 0
            response.redirectedUrl == '/mandarine/index'
            flash.message != null
    }
}
