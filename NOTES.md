## Tips and tricks:
- `springfox-boot-starter` does not work for Spring boot as springfox-swagger2 version 3.0.0 is broken
- `springfox-swagger2`, `springfox-swagger-ui`, `springfox-bean-validators` seems work correctly with 2.9.2 
but should be added all manually
- To enable validators - `@Import(BeanValidatorPluginsConfiguration.class)` into Swagger configuration with Docket bean
- Web MVC does not work correctly - no view names, model is not shown correctly as well
- Allows to send requests, provides sample data
