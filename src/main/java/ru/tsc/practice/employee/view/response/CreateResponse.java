package ru.tsc.practice.employee.view.response;

public class CreateResponse{
    private Long id;

    public CreateResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != CreateResponse.class) return false;
        CreateResponse resp = (CreateResponse) obj;
        return getId().equals(resp.getId());
    }

}
