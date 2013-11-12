package solardivehtest

class Mandarine implements Tangerine {

    String pipe

    static hasMany = [mandarineHistory:MandarineHistory]

    static constraints = {
    }

    void foo() {
        def history = new MandarineHistory()
        history.mandarine = this
        history.history.details = this.pipe
        historyMaker.insertHistory(history)
    }
}
