package springboot.config;

public class SpringConstants {
    public enum ROLE {

        ADMIN(1),
        MANAGER(2),
        EMPLOYEE(3);
        final int roleId;
        ROLE(int roleId) {
            this.roleId=roleId;
        }
    }
    public enum API {
        GET_ALL_EMPLOYEES("http://localhost:8081/rest/employees"),
        GET_EMPLOYEES("http://localhost:8081/rest/employees/{employeeId}"),
        POST_EMPLOYEES("http://localhost:8081/rest/employees"),
        UPDATE_EMPLOYEES("http://localhost:8081/rest/employees"),
        DELETE_EMPLOYEES("http://localhost:8081/rest/employees/{employeeId}");
        final String apiUrl;
        API(String apiUrl) {
            this.apiUrl = apiUrl;
        }
    }
}
