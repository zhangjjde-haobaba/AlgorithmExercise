package clonetest;

/**
 * Created by jiang on 10/20/23 12:14 PM
 * 深克隆
 * 1.都需要实现Cloneable接口
 */
public class Test {
    public static void main(String[] args) throws Exception{

        Address address = new Address(001,"北京");
        People p1 = new People(1,"java",address);
        People p2 = p1.clone();
        p1.getAddress().setCity("上海");
        System.out.println("P1:"+p1.getAddress().getCity()+"P2:"+p2.getAddress().getCity());


    }

    static class People implements Cloneable{
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

        @Override
        protected People clone() throws CloneNotSupportedException {
            People people =  (People)super.clone();
            people.setAddress(this.address.clone());
            return people;
        }
    }

    static class Address implements Cloneable{
        private Integer id;
        private String city;

        @Override
        protected Address clone() throws CloneNotSupportedException {
            return (Address)super.clone();
        }

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
