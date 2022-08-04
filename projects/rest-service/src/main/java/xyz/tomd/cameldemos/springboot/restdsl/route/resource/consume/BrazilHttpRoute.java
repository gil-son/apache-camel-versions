package xyz.tomd.cameldemos.springboot.restdsl.route.resource.consume;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;
import xyz.tomd.cameldemos.springboot.restdsl.dto.BrazilAddress;

import static org.apache.camel.LoggingLevel.INFO;


@Component
public class BrazilHttpRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {




        JacksonDataFormat addressesDataFormat = new JacksonDataFormat(BrazilAddress.class);


        from("timer:foo?period=100000")
                .routeId("Consume JSON Route")
                .log(INFO, this.log, "This will be second message...")
                .setBody().constant("{\n" +
                        "  \"cep\": \"01001-000\",\n" +
                        "  \"logradouro\": \"Praça da Sé\",\n" +
                        "  \"complemento\": \"lado ímpar\",\n" +
                        "  \"bairro\": \"Sé\",\n" +
                        "  \"localidade\": \"São Paulo\",\n" +
                        "  \"uf\": \"SP\",\n" +
                        "  \"ibge\": \"3550308\",\n" +
                        "  \"gia\": \"1004\",\n" +
                        "  \"ddd\": \"11\",\n" +
                        "  \"siafi\": \"7107\"\n" +
                        "}")
                .unmarshal(addressesDataFormat)
                .log(INFO, this.log, "Deserialized Data: ${body}") // "deserializa" um JSON para uma lista List

                /*
                  Marshalling é parecido com serialização, é uma técnica de transformar um objeto binário adequado
                   para a memória em um objeto em formato adequado para transporte entre processos, possivelmente em
                   máquinas diferentes.

                   Unmarshalling, faz o inverso
                 */

                .marshal(addressesDataFormat)

                .log(INFO, this.log, "Serialized Data: ${body}") // Com o Serialize, voce cria uma serie de dados, por exemplo um JSON.
                .setProperty("GETP", constant("consume get propertied"))
                .to("direct:get-rest-resource-consume");
    }

}
