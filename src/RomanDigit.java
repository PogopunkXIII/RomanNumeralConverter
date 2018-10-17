public enum RomanDigit {
    I("I"),
    V("V"),
    X("X"),
    L("L"),
    C("C"),
    D("D"),
    M("M");

    private String value;

    private RomanDigit(String value) {this.value = value;}

    @Override
    public String toString() {return this.value;}
}
