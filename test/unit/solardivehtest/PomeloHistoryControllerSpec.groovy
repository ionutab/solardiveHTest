package solardivehtest



import grails.test.mixin.*
import spock.lang.*

@TestFor(PomeloHistoryController)
@Mock(PomeloHistory)
class PomeloHistoryControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.pomeloHistoryInstanceList
            model.pomeloHistoryInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.pomeloHistoryInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def pomeloHistory = new PomeloHistory()
            pomeloHistory.validate()
            controller.save(pomeloHistory)

        then:"The create view is rendered again with the correct model"
            model.pomeloHistoryInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            pomeloHistory = new PomeloHistory(params)

            controller.save(pomeloHistory)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/pomeloHistory/show/1'
            controller.flash.message != null
            PomeloHistory.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def pomeloHistory = new PomeloHistory(params)
            controller.show(pomeloHistory)

        then:"A model is populated containing the domain instance"
            model.pomeloHistoryInstance == pomeloHistory
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def pomeloHistory = new PomeloHistory(params)
            controller.edit(pomeloHistory)

        then:"A model is populated containing the domain instance"
            model.pomeloHistoryInstance == pomeloHistory
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/pomeloHistory/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def pomeloHistory = new PomeloHistory()
            pomeloHistory.validate()
            controller.update(pomeloHistory)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.pomeloHistoryInstance == pomeloHistory

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            pomeloHistory = new PomeloHistory(params).save(flush: true)
            controller.update(pomeloHistory)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/pomeloHistory/show/$pomeloHistory.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/pomeloHistory/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def pomeloHistory = new PomeloHistory(params).save(flush: true)

        then:"It exists"
            PomeloHistory.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(pomeloHistory)

        then:"The instance is deleted"
            PomeloHistory.count() == 0
            response.redirectedUrl == '/pomeloHistory/index'
            flash.message != null
    }
}
