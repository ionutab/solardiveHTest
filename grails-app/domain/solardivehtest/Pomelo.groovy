package solardivehtest

class Pomelo implements Tangerine {

    String name

    static hasMany = [pomeloHistory:PomeloHistory]

    static constraints = {
    }

    def beforeInsert(){
        System.out.println("11111111111")
    }

    def beforeUpdate(){
        System.out.println("3333333333")
        this.checkChanges()
    }

    def afterInsert(){
        System.out.println("22222222222")
        System.out.println("ID: " + this.id)
        System.out.println("Name: " + this.name)
    }

    void foo() {
        def history = new PomeloHistory()
        history.pomelo = this
        history.history.details = this.name
        historyMaker.insertHistory(history)
    }
}
