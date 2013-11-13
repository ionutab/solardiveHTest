package solardivehtest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MandarineController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Mandarine.list(params), model:[mandarineInstanceCount: Mandarine.count()]
    }

    def show(Mandarine mandarineInstance) {
        respond mandarineInstance
    }

    def create() {
        respond new Mandarine(params)
    }

    @Transactional
    def save(Mandarine mandarineInstance) {
        if (mandarineInstance == null) {
            notFound()
            return
        }

        if (mandarineInstance.hasErrors()) {
            respond mandarineInstance.errors, view:'create'
            return
        }

        mandarineInstance.save flush:true
        mandarineInstance.fooSave()
        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mandarineInstance.label', default: 'Mandarine'), mandarineInstance.id])
                redirect mandarineInstance
            }
            '*' { respond mandarineInstance, [status: CREATED] }
        }
    }

    def edit(Mandarine mandarineInstance) {
        respond mandarineInstance
    }

    @Transactional
    def update(Mandarine mandarineInstance) {
        if (mandarineInstance == null) {
            notFound()
            return
        }

        if (mandarineInstance.hasErrors()) {
            respond mandarineInstance.errors, view:'edit'
            return
        }

        mandarineInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Mandarine.label', default: 'Mandarine'), mandarineInstance.id])
                redirect mandarineInstance
            }
            '*'{ respond mandarineInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Mandarine mandarineInstance) {

        if (mandarineInstance == null) {
            notFound()
            return
        }

        mandarineInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Mandarine.label', default: 'Mandarine'), mandarineInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mandarineInstance.label', default: 'Mandarine'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
