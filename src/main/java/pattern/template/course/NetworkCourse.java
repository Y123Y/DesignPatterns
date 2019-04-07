package pattern.template.course;

public abstract class NetworkCourse {
    protected final void createCourse(){
        // 1.发布预习资料
        this.postPreResource();

        // 2.制作PPT
        this.createPPT();

        // 3.在线直播
        this.liveVideo();

        // 4.提交课件、课堂笔记
        this.postNote();

        // 5.提交源码
        this.postResource();

        // 6.布置作业
        if (needHomework()) {
            checkHomework();
        }
    }

    abstract void checkHomework();

    //钩子方法
    protected boolean needHomework() {
        return false;
    }

    final void postResource() {
        System.out.println("提交源代码");
    }

    final void postNote() {
        System.out.println("提交课件和笔记");
    }

    final void liveVideo() {
        System.out.println("直播授课");
    }

    final void createPPT(){
        System.out.println("创建授课PPT");
    }


    final void postPreResource() {
        System.out.println("分发预习资料");
    }
}
