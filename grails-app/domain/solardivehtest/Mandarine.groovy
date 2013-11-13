package solardivehtest

class Mandarine implements Tangerine {

    String pipe

    static hasMany = [mandarineHistory:MandarineHistory]

    static constraints = {
    }

    def beforeUpdate(){
        fooUpdate()
    }

    void fooSave() {
        def history = new MandarineHistory()
        history.mandarine = this
        history.history.details = this.pipe
        historyMaker.insertHistory(history)
    }

    void fooUpdate() {
        System.out.println("qqqq")
        Mandarine.withNewSession{
            session ->
                def oldMandarine = Mandarine.get(this.id)
                Mandarine.withTransaction {transaction ->
                    System.out.println("OLD: " + oldMandarine.pipe)
                    System.out.println("NEW: " + this.pipe)
                    def history = new MandarineHistory()
                    history.mandarine = this
                    history.history.details = oldMandarine.pipe + " <- " + this.pipe
                    historyMaker.insertHistory(history)
                }
        }
    }
}
