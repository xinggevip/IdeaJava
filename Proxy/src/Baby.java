public class Baby {
    public BabyProtocol proxy = null;
    public void cry(){
        // �ñ�ķȥ��Ӥ��
        this.proxy.listenCry();
    }

    public void huangry(){
        // �ñ�ķȥιӤ��
        this.proxy.listenHungry();
    }
}
