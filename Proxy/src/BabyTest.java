public class BabyTest {
    public static void main(String[] args){
        Baby baby = new Baby();
        Nanny nanny = new Nanny();
        baby.proxy = nanny;
        baby.cry();
        baby.huangry();
    }
}
