package com.directory.constants;
public class SpringConstants {
    public enum ROLES{
        ADMIN(1),
        MANAGER(2),
        EMPLOYEE(2);

        private long id;
        ROLES(long id) {
            this.id=id;
        }
        public Long getId() {
            return id;
        }
    }

    /*
    public static final String GET_ALL_EMPLOYEES="/employees";
    public static final String GET_EMPLOYEES="/employees/**";
    public static final String POST_EMPLOYEES="/employees";
    public static final String PUT_EMPLOYEES="/employees";
    public static final String DELETE_EMPLOYEES="/employees/**";
     */
     
}
