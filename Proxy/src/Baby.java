public class Baby {
    public BabyProtocol proxy = null;
    public void cry(){
        // 让保姆去哄婴儿
        this.proxy.listenCry();
    }

    public void huangry(){
        // 让保姆去喂婴儿
        this.proxy.listenHungry();
    }
}
