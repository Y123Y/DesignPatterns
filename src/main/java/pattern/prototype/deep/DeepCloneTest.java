package pattern.prototype.deep;

public class DeepCloneTest {
    public static void main(String[] args) {
        QiTianDaSheng qt = new QiTianDaSheng();

        try {
            QiTianDaSheng dc = (QiTianDaSheng) qt.clone();
            System.out.println("深克隆：" + (dc.getJinGuBang() == qt.getJinGuBang()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        QiTianDaSheng sc = qt.shallowClone(qt);
        System.out.println("浅克隆：" + (sc.getJinGuBang() == qt.getJinGuBang()));
    }
}
