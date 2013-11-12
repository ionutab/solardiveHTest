package solardivehtest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PomeloHistoryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PomeloHistory.list(params), model:[pomeloHistoryInstanceCount: PomeloHistory.count()]
    }

    def show(PomeloHistory pomeloHistoryInstance) {
        respond pomeloHistoryInstance
    }

    def create() {
        respond new PomeloHistory(params)
    }

    @Transactional
    def save(PomeloHistory pomeloHistoryInstance) {
        if (pomeloHistoryInstance == null) {
            notFound()
            return
        }

        if (pomeloHistoryInstance.hasErrors()) {
            respond pomeloHistoryInstance.errors, view:'create'
            return
        }

        pomeloHistoryInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pomeloHistoryInstance.label', default: 'PomeloHistory'), pomeloHistoryInstance.id])
                redirect pomeloHistoryInstance
            }
            '*' { respond pomeloHistoryInstance, [status: CREATED] }
        }
    }

    def edit(PomeloHistory pomeloHistoryInstance) {
        respond pomeloHistoryInstance
    }

    @Transactional
    def update(PomeloHistory pomeloHistoryInstance) {
        if (pomeloHistoryInstance == null) {
            notFound()
            return
        }

        if (pomeloHistoryInstance.hasErrors()) {
            respond pomeloHistoryInstance.errors, view:'edit'
            return
        }

        pomeloHistoryInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PomeloHistory.label', default: 'PomeloHistory'), pomeloHistoryInstance.id])
                redirect pomeloHistoryInstance
            }
            '*'{ respond pomeloHistoryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PomeloHistory pomeloHistoryInstance) {

        if (pomeloHistoryInstance == null) {
            notFound()
            return
        }

        pomeloHistoryInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PomeloHistory.label', default: 'PomeloHistory'), pomeloHistoryInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pomeloHistoryInstance.label', default: 'PomeloHistory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
