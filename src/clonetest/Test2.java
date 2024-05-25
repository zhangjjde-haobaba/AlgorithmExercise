package clonetest;

/**
 * Created by jiang on 10/20/23 12:29 PM
 * 深克隆
 * 2.基于构造器实现
 */
public class Test2 {
    public static void main(String[] args) {
        Address address = new Address(001,"北京");
        People p1 = new People(1,"Java",address);
        People p2 = new People(p1.id,p1.name,new Address(p1.getAddress().getId(),p1.getAddress().getName()));
        p1.getAddress().setName("上海");
        System.out.println("P1:"+p1.getAddress().getName()+"P2:"+p2.getAddress().getName());

    }

    static class People{
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

    static class Address{
        private Integer id;
        private String name;

        public Address(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
