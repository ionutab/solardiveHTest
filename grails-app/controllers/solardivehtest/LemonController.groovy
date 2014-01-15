package solardivehtest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LemonController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Lemon.list(params), model:[lemonInstanceCount: Lemon.count()]
    }

    def show(Lemon lemonInstance) {
        respond lemonInstance
    }

    def create() {
        respond new Lemon(params)
    }

    @Transactional
    def save(Lemon lemonInstance) {
        if (lemonInstance == null) {
            notFound()
            return
        }

        if (lemonInstance.hasErrors()) {
            respond lemonInstance.errors, view:'create'
            return
        }

        lemonInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lemonInstance.label', default: 'Lemon'), lemonInstance.id])
                redirect lemonInstance
            }
            '*' { respond lemonInstance, [status: CREATED] }
        }
    }

    def edit(Lemon lemonInstance) {
        respond lemonInstance
    }

    @Transactional
    def update(Lemon lemonInstance) {
        if (lemonInstance == null) {
            notFound()
            return
        }

        if (lemonInstance.hasErrors()) {
            respond lemonInstance.errors, view:'edit'
            return
        }

        lemonInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Lemon.label', default: 'Lemon'), lemonInstance.id])
                redirect lemonInstance
            }
            '*'{ respond lemonInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Lemon lemonInstance) {

        if (lemonInstance == null) {
            notFound()
            return
        }

        lemonInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Lemon.label', default: 'Lemon'), lemonInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lemonInstance.label', default: 'Lemon'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
