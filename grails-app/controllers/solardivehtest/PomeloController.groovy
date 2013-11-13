package solardivehtest

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PomeloController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pomelo.list(params), model:[pomeloInstanceCount: Pomelo.count()]
    }

    def show(Pomelo pomeloInstance) {
        respond pomeloInstance
    }

    def create() {
        respond new Pomelo(params)
    }

    @Transactional
    def save(Pomelo pomeloInstance) {
        if (pomeloInstance == null) {
            notFound()
            return
        }

        if (pomeloInstance.hasErrors()) {
            respond pomeloInstance.errors, view:'create'
            return
        }

        if(pomeloInstance.validate()){
            pomeloInstance.save flush:true
            pomeloInstance.fooSave()
        }

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pomeloInstance.label', default: 'Pomelo'), pomeloInstance.id])
                redirect pomeloInstance
            }
            '*' { respond pomeloInstance, [status: CREATED] }
        }
    }

    def edit(Pomelo pomeloInstance) {
        respond pomeloInstance
    }

    @Transactional
    def update(Pomelo pomeloInstance) {
        if (pomeloInstance == null) {
            notFound()
            return
        }

        if (pomeloInstance.hasErrors()) {
            respond pomeloInstance.errors, view:'edit'
            return
        }

        pomeloInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pomelo.label', default: 'Pomelo'), pomeloInstance.id])
                redirect pomeloInstance
            }
            '*'{ respond pomeloInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Pomelo pomeloInstance) {

        if (pomeloInstance == null) {
            notFound()
            return
        }

        pomeloInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pomelo.label', default: 'Pomelo'), pomeloInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pomeloInstance.label', default: 'Pomelo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
