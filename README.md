# Spring-security-basic-auth
It has 2 spring security projects -> which shows (1) How to Register a user (2) How extract login user and (3) how to create Login API <br>
(Q) Difference between hasRole("ADMIN") hasAnyRole("USER","ADMIN") and hasAuthority("ADMIN")<br> hasAnyAuthority("USER","ADMIN") ? <br>
answer: hasRole(): insert ROLE_ prefix in database <br>
        hasAuthority(): does not insert any prefix <br>
