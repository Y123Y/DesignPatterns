package pattern.prototype.deep;

import java.io.*;
import java.util.Date;

public class QiTianDaSheng extends Monkey implements Cloneable, Serializable {
    private JinGuBang jinGuBang;

    public QiTianDaSheng() {
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    public JinGuBang getJinGuBang() {
        return jinGuBang;
    }

    public void setJinGuBang(JinGuBang jinGuBang) {
        this.jinGuBang = jinGuBang;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    private Object deepClone() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            QiTianDaSheng copy = (QiTianDaSheng) ois.readObject();
            copy.birthday = new Date();

            return copy;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public QiTianDaSheng shallowClone(QiTianDaSheng target){
        QiTianDaSheng copy = new QiTianDaSheng();
        copy.height = target.height;
        copy.weight = target.weight;
        copy.jinGuBang = target.jinGuBang;
        copy.birthday = new Date();
        return copy;
    }
}
