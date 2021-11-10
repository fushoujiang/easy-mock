package com.fsj.mockeasy;




import java.util.List;

/**
 * 单多多活动报名详情
 */
public class MockTestDTO {


    private Long id;


    private String name;

    Boolean flag;



    List<MoreOrderDTO> orderDTOS;


    public Long getId() {
        return id;
    }

    public MockTestDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MockTestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getFlag() {
        return flag;
    }

    public MockTestDTO setFlag(Boolean flag) {
        this.flag = flag;
        return this;
    }

    public List<MoreOrderDTO> getOrderDTOS() {
        return orderDTOS;
    }

    public MockTestDTO setOrderDTOS(List<MoreOrderDTO> orderDTOS) {
        this.orderDTOS = orderDTOS;
        return this;
    }

    public static class MoreOrderDTO{

        String  name;


        String address;

        public String getName() {
            return name;
        }

        public MoreOrderDTO setName(String name) {
            this.name = name;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public MoreOrderDTO setAddress(String address) {
            this.address = address;
            return this;
        }
    }
}
