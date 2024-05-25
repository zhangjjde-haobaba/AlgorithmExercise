package clonetest;

import java.io.*;

/**
 * Created by jiang on 10/20/23 12:39 PM
 * 深克隆
 * 3.通过IO流实现(要实现序列化接口)
 */
public class Test3 {
    public static void main(String[] args) {
        Address address = new Address(001,"北京");
        People p1 = new People(1,"Java",address);
        People p2 = (People)StreamClone.clone(p1);
        p1.getAddress().setCity("上海");
        System.out.println("P1:"+p1.getAddress().getCity()+"P2:"+p2.getAddress().getCity());

    }

    static class StreamClone{

        public static <T extends Serializable> T clone(People obj){
            T cloneObj = null;
            try {

                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bo);
                oos.writeObject(obj);
                oos.close();
                ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
                ObjectInputStream oi = new ObjectInputStream(bi);
                cloneObj = (T)oi.readObject();

                //实际上是将数据写入到ByteArrayOutputStream中再通过ByteArrayInputStream读取出来ObjectInputStream反序列化成对象
                //序列化:
                //使用ObjectOutputStream将对象序列化，即将对象转换为字节流。
                //这个字节流被写入到ByteArrayOutputStream中。
                //反序列化:
                //使用ByteArrayInputStream从ByteArrayOutputStream中读取之前存储的字节流。
                //使用ObjectInputStream从ByteArrayInputStream中读取字节流，并将其反序列化，即将字节流转换回对象。


            }catch (Exception e){

            }
            return cloneObj;
        }

    }

    static class People implements Serializable{
        private Integer id;
        private String name;
        private Address address;

        public People(Integer id, String name, Address address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Address getAddress() {
            return address;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    static class Address implements Serializable {
        private Integer id;
        private String city;

        public Address(Integer id, String city) {
            this.id = id;
            this.city = city;
        }

        public Integer getId() {
            return id;
        }

        public String getCity() {
            return city;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
