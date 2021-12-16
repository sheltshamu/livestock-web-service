package zw.co.lws.livestockwebservice.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Response<T> {
    private Status status;
    private T payload;
    private Object metadata;

    public Response(T payload) {
        this.payload=payload;
    }

    public Response<T> ok(){
        Response<T> response = new Response<>();
        response.setStatus(Status.OK);
        return response;
    }

    public Response<T> badRequest(){
        Response<T> response = new Response<>();
        response.setStatus(Status.BAD_REQUEST);
        return response;
    }

    public Response<T> notFound(){
        Response<T> response = new Response<>();
        response.setStatus(Status.NOT_FOUND);
        return response;
    }

}


