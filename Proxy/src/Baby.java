public class Baby {
    public BabyProtocol proxy = null;
    public void cry(){
        // ÈÃ±£Ä·È¥ºåÓ¤¶ù
        this.proxy.listenCry();
    }

    public void huangry(){
        // ÈÃ±£Ä·È¥Î¹Ó¤¶ù
        this.proxy.listenHungry();
    }
}
