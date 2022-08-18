package com.javatechie.spring.camel.api.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpMethods;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestHttp extends RouteBuilder{
	
	
	@Override
	public void configure() throws Exception {


		from("timer://foo?fixedRate=true&delay=0&period=100000")


				.removeHeader(Exchange.HTTP_METHOD)
				.setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
				//.to("http4://localhost:8080/book")
				.setBody(constant("{\n" +
						"  \"id\": \"string\",\n" +
						"  \"codigoInstituicaoFinanceira\": 0,\n" +
						"  \"modalidadeCredito\": \"CPRF\",\n" +
						"  \"numeroCPFCNPJ\": \"string\",\n" +
						"  \"numeroPedido\": 0,\n" +
						"  \"situacaoFormalizacao\": \"string\",\n" +
						"  \"dadosBancariosCliente\": {\n" +
						"    \"numeroAgencia\": 0,\n" +
						"    \"digitoAgencia\": 0,\n" +
						"    \"numeroConta\": 0,\n" +
						"    \"digitoConta\": \"string\",\n" +
						"    \"codigoClienteInstituicaoFinanceira\": \"string\"\n" +
						"  },\n" +
						"  \"dadosCadastraisCliente\": {\n" +
						"    \"nomeUsuario\": \"string\",\n" +
						"    \"tipoPessoaCliente\": \"FISICA\",\n" +
						"    \"nomeSocialCliente\": \"string\",\n" +
						"    \"nomeCliente\": \"string\",\n" +
						"    \"nacionalidade\": \"string\",\n" +
						"    \"profissao\": \"string\",\n" +
						"    \"datahoraInclusao\": \"2022-08-16T23:32:03.789Z\",\n" +
						"    \"datahoraAlteracao\": \"2022-08-16T23:32:03.789Z\",\n" +
						"    \"documentosIdentificacao\": [\n" +
						"      {\n" +
						"        \"numeroSequencia\": 0,\n" +
						"        \"tipoDocumento\": \"string\",\n" +
						"        \"numeroDocumento\": \"string\",\n" +
						"        \"orgaoEmissor\": \"string\",\n" +
						"        \"ufEmissao\": \"string\",\n" +
						"        \"datahoraInclusao\": \"2022-08-16T23:32:03.789Z\",\n" +
						"        \"datahoraAlteracao\": \"2022-08-16T23:32:03.789Z\"\n" +
						"      }\n" +
						"    ],\n" +
						"    \"enderecoCliente\": [\n" +
						"      {\n" +
						"        \"numeroSequencia\": 0,\n" +
						"        \"tipoEndereco\": \"string\",\n" +
						"        \"numeroCEP\": \"string\",\n" +
						"        \"logradouro\": \"string\",\n" +
						"        \"numero\": \"string\",\n" +
						"        \"complemento\": \"string\",\n" +
						"        \"bairro\": \"string\",\n" +
						"        \"municipio\": \"string\",\n" +
						"        \"uf\": \"string\"\n" +
						"      }\n" +
						"    ],\n" +
						"    \"emails\": [\n" +
						"      {\n" +
						"        \"numeroSequencia\": 0,\n" +
						"        \"tipoEmail\": \"string\",\n" +
						"        \"enderecoEmail\": \"user@example.com\"\n" +
						"      }\n" +
						"    ],\n" +
						"    \"telefones\": [\n" +
						"      {\n" +
						"        \"numeroSequencia\": 0,\n" +
						"        \"tipoTelefone\": \"RESIDENCIAL\",\n" +
						"        \"numeroDDI\": \"string\",\n" +
						"        \"codigoDDD\": \"string\",\n" +
						"        \"numeroTelefone\": \"string\"\n" +
						"      }\n" +
						"    ],\n" +
						"    \"regimeCivil\": {\n" +
						"      \"estadoCivil\": \"string\",\n" +
						"      \"nomeConjuge\": \"string\",\n" +
						"      \"temCPF\": true,\n" +
						"      \"numeroCPF\": \"string\",\n" +
						"      \"dataNascimento\": \"2022-08-16\",\n" +
						"      \"nomeMaeConjuge\": \"string\"\n" +
						"    }\n" +
						"  },\n" +
						"  \"caracteristicasOperacao\": {\n" +
						"    \"produto\": \"string\",\n" +
						"    \"atividade\": \"string\",\n" +
						"    \"caracteristicasVariedade\": \"string\",\n" +
						"    \"producao\": 0,\n" +
						"    \"quantidadeProduto\": 0,\n" +
						"    \"unidadeMedida\": \"string\",\n" +
						"    \"formaAcondicionamento\": \"string\",\n" +
						"    \"safra\": \"string\",\n" +
						"    \"situacaoProduto\": 0,\n" +
						"    \"indiceApuracaoProduto\": \"string\",\n" +
						"    \"indiceApuracaoProdutoCliente\": \"string\",\n" +
						"    \"precoUnitario\": 0,\n" +
						"    \"precoUnitarioInformadoCliente\": 0,\n" +
						"    \"dataLiberacao\": \"2022-08-16\",\n" +
						"    \"dataPrimeiroVencimento\": \"2022-08-16\",\n" +
						"    \"dataUltimoVencimento\": \"2022-08-16\",\n" +
						"    \"valorTotalFormalizacao\": 0,\n" +
						"    \"lastroLCA\": \"string\",\n" +
						"    \"encargos\": {\n" +
						"      \"rentabilidadeIndexador\": 0,\n" +
						"      \"quantidadeDiasAnoBase\": 0,\n" +
						"      \"percentualPosFixado\": 0,\n" +
						"      \"valorJuros\": 0,\n" +
						"      \"taxaJurosAM\": 0,\n" +
						"      \"taxaJurosAA\": 0,\n" +
						"      \"criterioCalculoJuros\": 0,\n" +
						"      \"taxaIOF\": 0,\n" +
						"      \"taxaIOFAdicional\": 0,\n" +
						"      \"valorIOF\": 0,\n" +
						"      \"valorIOFAdicional\": 0\n" +
						"    },\n" +
						"    \"prazoTotalOperacao\": 0,\n" +
						"    \"tipoProduto\": 0,\n" +
						"    \"formaPagamento\": \"string\",\n" +
						"    \"tipoAmortizacao\": \"string\",\n" +
						"    \"agenciaDebito\": 0,\n" +
						"    \"contaDebito\": 0,\n" +
						"    \"dataEmissaoCedula\": \"2022-08-16\",\n" +
						"    \"assinaturaDigital\": true,\n" +
						"    \"indicadorUtilizarLimite\": true,\n" +
						"    \"indicadorDebitoParcial\": true\n" +
						"  },\n" +
						"  \"propriedadesRurais\": [\n" +
						"    {\n" +
						"      \"numeroSequencia\": 0,\n" +
						"      \"nomeImovel\": \"string\",\n" +
						"      \"numeroMatricula\": \"string\",\n" +
						"      \"areaTotalImovel\": 0,\n" +
						"      \"areaExplorada\": 0,\n" +
						"      \"produtosProduzidos\": [\n" +
						"        {\n" +
						"          \"numeroSequencia\": 0,\n" +
						"          \"nomeProduto\": \"string\",\n" +
						"          \"nomeVariedadeProduto\": \"string\",\n" +
						"          \"areaProduto\": 0,\n" +
						"          \"quantidadeCabecas\": 0,\n" +
						"          \"selecionadoPenhor\": true\n" +
						"        }\n" +
						"      ],\n" +
						"      \"tipoExploracao\": \"string\",\n" +
						"      \"proprietarios\": [\n" +
						"        {\n" +
						"          \"numeroSequencia\": 0,\n" +
						"          \"nomeProprietario\": \"string\",\n" +
						"          \"numeroCPFCNPJ\": \"string\"\n" +
						"        }\n" +
						"      ],\n" +
						"      \"areaTotalPecuaria\": 0,\n" +
						"      \"areaTotalAgricola\": 0,\n" +
						"      \"areaDemais\": 0,\n" +
						"      \"numeroCAR\": \"string\",\n" +
						"      \"codigoCCIR\": \"string\",\n" +
						"      \"codigoNIRF\": \"string\",\n" +
						"      \"origemCadastroImovel\": \"string\",\n" +
						"      \"codigoImovelSistemaOrigem\": \"string\",\n" +
						"      \"selecionadoFormalizacao\": true,\n" +
						"      \"selecionadoGarantia\": true,\n" +
						"      \"endereco\": {\n" +
						"        \"numeroCEP\": \"string\",\n" +
						"        \"logradouro\": \"string\",\n" +
						"        \"numero\": \"string\",\n" +
						"        \"complemento\": \"string\",\n" +
						"        \"municipio\": \"string\",\n" +
						"        \"uf\": \"AA\"\n" +
						"      }\n" +
						"    }\n" +
						"  ],\n" +
						"  \"garantias\": {\n" +
						"    \"codigoGarantia\": 0,\n" +
						"    \"descricaoGarantia\": \"string\",\n" +
						"    \"valorGarantias\": 0,\n" +
						"    \"numeroContratoMae\": 0,\n" +
						"    \"penhores\": [\n" +
						"      {\n" +
						"        \"numeroSequencia\": 0,\n" +
						"        \"tipoPenhor\": \"string\",\n" +
						"        \"nomeProduto\": \"string\",\n" +
						"        \"quantidade\": 0,\n" +
						"        \"nomeVariedadeProduto\": \"string\",\n" +
						"        \"unidadeMedida\": \"string\",\n" +
						"        \"valorUnitario\": 0,\n" +
						"        \"numeroCRI\": \"string\",\n" +
						"        \"nomeComarca\": \"string\",\n" +
						"        \"municipioComarca\": \"string\",\n" +
						"        \"ufComarca\": \"string\",\n" +
						"        \"agricola\": {\n" +
						"          \"safra\": \"string\",\n" +
						"          \"expectativaProducao\": \"string\",\n" +
						"          \"areaProduto\": 0,\n" +
						"          \"areaProdutoUnidadeMedida\": \"string\"\n" +
						"        },\n" +
						"        \"pecuario\": {\n" +
						"          \"animal\": \"string\",\n" +
						"          \"raca\": \"string\",\n" +
						"          \"idadeMedia\": \"string\",\n" +
						"          \"pelagem\": \"string\",\n" +
						"          \"marca\": \"string\",\n" +
						"          \"localMarca\": \"string\"\n" +
						"        },\n" +
						"        \"fielDepositario\": {\n" +
						"          \"nome\": \"string\",\n" +
						"          \"numeroCPFCNPJ\": \"string\",\n" +
						"          \"endereco\": {\n" +
						"            \"numeroCEP\": \"string\",\n" +
						"            \"logradouro\": \"string\",\n" +
						"            \"numero\": \"string\",\n" +
						"            \"complemento\": \"string\",\n" +
						"            \"municipio\": \"string\",\n" +
						"            \"uf\": \"string\"\n" +
						"          },\n" +
						"          \"telefone\": {\n" +
						"            \"numeroSequencia\": 0,\n" +
						"            \"tipoTelefone\": \"RESIDENCIAL\",\n" +
						"            \"numeroDDI\": \"string\",\n" +
						"            \"codigoDDD\": \"string\",\n" +
						"            \"numeroTelefone\": \"string\"\n" +
						"          },\n" +
						"          \"email\": \"string\",\n" +
						"          \"certidaoConjuntaRFB\": \"string\",\n" +
						"          \"validadeCertidao\": \"2022-08-16\"\n" +
						"        },\n" +
						"        \"propriedadeRural\": {\n" +
						"          \"nomePropriedade\": \"string\",\n" +
						"          \"numeroMatricula\": \"string\",\n" +
						"          \"areaTotalImovel\": 0,\n" +
						"          \"areaExplorada\": 0,\n" +
						"          \"tipoExploracao\": \"string\",\n" +
						"          \"proprietarios\": [\n" +
						"            {\n" +
						"              \"numeroSequencia\": 0,\n" +
						"              \"nomeProprietario\": \"string\",\n" +
						"              \"numeroCPFCNPJ\": \"string\"\n" +
						"            }\n" +
						"          ],\n" +
						"          \"areaTotalPecuaria\": 0,\n" +
						"          \"areaTotalAgricola\": 0,\n" +
						"          \"areaDemais\": 0,\n" +
						"          \"numeroCAR\": \"string\",\n" +
						"          \"codigoCCIR\": \"string\",\n" +
						"          \"codigoNIRF\": \"string\",\n" +
						"          \"origemCadastroImovel\": \"string\",\n" +
						"          \"codigoImovelSistemaOrigem\": \"string\",\n" +
						"          \"endereco\": {\n" +
						"            \"numeroCEP\": \"string\",\n" +
						"            \"logradouro\": \"string\",\n" +
						"            \"numero\": \"string\",\n" +
						"            \"complemento\": \"string\",\n" +
						"            \"municipio\": \"string\",\n" +
						"            \"uf\": \"string\"\n" +
						"          }\n" +
						"        }\n" +
						"      }\n" +
						"    ],\n" +
						"    \"avalistas\": [\n" +
						"      {\n" +
						"        \"numeroSequencia\": 0,\n" +
						"        \"numeroCPFCNPJ\": \"string\",\n" +
						"        \"nome\": \"string\",\n" +
						"        \"nacionalidade\": \"string\",\n" +
						"        \"tipoPessoa\": \"FISICA\",\n" +
						"        \"documentoIdentificacao\": {\n" +
						"          \"numeroSequencia\": 0,\n" +
						"          \"tipoDocumento\": \"string\",\n" +
						"          \"numeroDocumento\": \"string\",\n" +
						"          \"orgaoEmissor\": \"string\",\n" +
						"          \"ufEmissao\": \"string\"\n" +
						"        },\n" +
						"        \"profissao\": \"string\",\n" +
						"        \"telefone\": {\n" +
						"          \"numeroSequencia\": 0,\n" +
						"          \"tipoTelefone\": \"RESIDENCIAL\",\n" +
						"          \"numeroDDI\": \"string\",\n" +
						"          \"codigoDDD\": \"string\",\n" +
						"          \"numeroTelefone\": \"string\"\n" +
						"        },\n" +
						"        \"enderecoEmail\": \"string\",\n" +
						"        \"endereco\": {\n" +
						"          \"numeroSequencia\": 0,\n" +
						"          \"tipoEndereco\": \"string\",\n" +
						"          \"numeroCEP\": \"string\",\n" +
						"          \"logradouro\": \"string\",\n" +
						"          \"numero\": \"string\",\n" +
						"          \"complemento\": \"string\",\n" +
						"          \"bairro\": \"string\",\n" +
						"          \"municipio\": \"string\",\n" +
						"          \"uf\": \"string\"\n" +
						"        },\n" +
						"        \"regimeEstadoCivil\": \"string\",\n" +
						"        \"dadosConjuge\": {\n" +
						"          \"nacionalidade\": \"string\",\n" +
						"          \"nomeConjuge\": \"string\",\n" +
						"          \"documentoIdentificacao\": {\n" +
						"            \"numeroSequencia\": 0,\n" +
						"            \"tipoDocumento\": \"string\",\n" +
						"            \"numeroDocumento\": \"string\",\n" +
						"            \"orgaoEmissor\": \"string\",\n" +
						"            \"ufEmissao\": \"string\"\n" +
						"          },\n" +
						"          \"numeroCPF\": \"string\",\n" +
						"          \"regimeEstadoCivil\": \"string\",\n" +
						"          \"telefone\": {\n" +
						"            \"numeroSequencia\": 0,\n" +
						"            \"tipoTelefone\": \"RESIDENCIAL\",\n" +
						"            \"numeroDDI\": \"string\",\n" +
						"            \"codigoDDD\": \"string\",\n" +
						"            \"numeroTelefone\": \"string\"\n" +
						"          },\n" +
						"          \"email\": \"string\",\n" +
						"          \"endereco\": {\n" +
						"            \"numeroCEP\": \"string\",\n" +
						"            \"logradouro\": \"string\",\n" +
						"            \"numero\": \"string\",\n" +
						"            \"complemento\": \"string\",\n" +
						"            \"municipio\": \"string\",\n" +
						"            \"uf\": \"string\"\n" +
						"          }\n" +
						"        }\n" +
						"      }\n" +
						"    ],\n" +
						"    \"hipotecas\": [\n" +
						"      {\n" +
						"        \"numeroSequencia\": 0,\n" +
						"        \"tipoGarantiaImovel\": \"string\",\n" +
						"        \"tipoImovel\": \"string\",\n" +
						"        \"variedadeImovelUrbano\": \"string\",\n" +
						"        \"nomeImovelGarantia\": \"string\",\n" +
						"        \"municipio\": \"string\",\n" +
						"        \"uf\": \"string\",\n" +
						"        \"imovelSelecionado\": true,\n" +
						"        \"certidaoConjuntaRFB\": \"string\",\n" +
						"        \"validadeCertidao\": \"2022-08-16\",\n" +
						"        \"numeroAvaliacaoInstituicaoFinanceira\": \"string\",\n" +
						"        \"dataAvaliacao\": \"2022-08-16\",\n" +
						"        \"valorAvaliacao\": 0,\n" +
						"        \"nomeComarca\": \"string\",\n" +
						"        \"ufComarca\": \"string\",\n" +
						"        \"nomeCartorio\": \"string\",\n" +
						"        \"numeroLivro\": \"string\",\n" +
						"        \"numeroFolha\": \"string\",\n" +
						"        \"grauHipoteca\": \"string\",\n" +
						"        \"tamanhoArea\": 0,\n" +
						"        \"unidadeMedidaArea\": \"string\",\n" +
						"        \"numeroMatricula\": \"string\",\n" +
						"        \"observacao\": \"string\",\n" +
						"        \"proprietarios\": [\n" +
						"          {\n" +
						"            \"numeroSequencia\": 0,\n" +
						"            \"tipoPessoa\": \"string\",\n" +
						"            \"numeroCPFCNPJ\": \"string\",\n" +
						"            \"nome\": \"string\",\n" +
						"            \"nomeSocial\": \"string\",\n" +
						"            \"documentoIdentificacao\": {\n" +
						"              \"numeroSequencia\": 0,\n" +
						"              \"tipoDocumento\": \"string\",\n" +
						"              \"numeroDocumento\": \"string\",\n" +
						"              \"orgaoEmissor\": \"string\",\n" +
						"              \"ufEmissao\": \"string\"\n" +
						"            },\n" +
						"            \"email\": [\n" +
						"              {\n" +
						"                \"numeroSequencia\": 0,\n" +
						"                \"endereco\": \"string\"\n" +
						"              }\n" +
						"            ],\n" +
						"            \"profissao\": \"string\",\n" +
						"            \"nacionalidade\": \"string\",\n" +
						"            \"estadoCivil\": \"string\",\n" +
						"            \"dadosConjuge\": {\n" +
						"              \"numeroCPF\": \"string\",\n" +
						"              \"nome\": \"string\",\n" +
						"              \"email\": \"string\",\n" +
						"              \"profissao\": \"string\",\n" +
						"              \"nacionalidade\": \"string\",\n" +
						"              \"documentoIdentificacao\": {\n" +
						"                \"numeroSequencia\": 0,\n" +
						"                \"tipoDocumento\": \"string\",\n" +
						"                \"numeroDocumento\": \"string\",\n" +
						"                \"orgaoEmissor\": \"string\",\n" +
						"                \"ufEmissao\": \"string\"\n" +
						"              },\n" +
						"              \"endereco\": {\n" +
						"                \"numeroCEP\": \"string\",\n" +
						"                \"logradouro\": \"string\",\n" +
						"                \"numero\": \"string\",\n" +
						"                \"complemento\": \"string\",\n" +
						"                \"municipio\": \"string\",\n" +
						"                \"uf\": \"string\"\n" +
						"              },\n" +
						"              \"telefone\": {\n" +
						"                \"numeroSequencia\": 0,\n" +
						"                \"tipoTelefone\": \"RESIDENCIAL\",\n" +
						"                \"numeroDDI\": \"string\",\n" +
						"                \"codigoDDD\": \"string\",\n" +
						"                \"numeroTelefone\": \"string\"\n" +
						"              }\n" +
						"            },\n" +
						"            \"endereco\": {\n" +
						"              \"numeroCEP\": \"string\",\n" +
						"              \"logradouro\": \"string\",\n" +
						"              \"numero\": \"string\",\n" +
						"              \"complemento\": \"string\",\n" +
						"              \"municipio\": \"string\",\n" +
						"              \"uf\": \"string\"\n" +
						"            },\n" +
						"            \"telefone\": [\n" +
						"              {\n" +
						"                \"numeroSequencia\": 0,\n" +
						"                \"tipoTelefone\": \"RESIDENCIAL\",\n" +
						"                \"numeroDDI\": \"string\",\n" +
						"                \"codigoDDD\": \"string\",\n" +
						"                \"numeroTelefone\": \"string\"\n" +
						"              }\n" +
						"            ]\n" +
						"          }\n" +
						"        ]\n" +
						"      }\n" +
						"    ]\n" +
						"  },\n" +
						"  \"dadosInstituicao\": {\n" +
						"    \"nomeInstituicao\": \"string\",\n" +
						"    \"numeroCNPJ\": \"string\",\n" +
						"    \"numeroCEP\": \"string\",\n" +
						"    \"logradouro\": \"string\",\n" +
						"    \"numero\": \"string\",\n" +
						"    \"complemento\": \"string\",\n" +
						"    \"municipio\": \"string\",\n" +
						"    \"uf\": \"string\"\n" +
						"  },\n" +
						"  \"comentarioBPOLiberacaoDossie\": \"string\",\n" +
						"  \"datahoraInclusaoFormalizacao\": \"2022-08-16T23:32:03.790Z\",\n" +
						"  \"datahoraAtualizacaoFomalizacao\": \"2022-08-16T23:32:03.790Z\",\n" +
						"  \"simulacaoOrigem\": {\n" +
						"    \"idSimulacao\": \"string\",\n" +
						"    \"codigoInstituicaoFinanceira\": \"string\",\n" +
						"    \"modalidadeCredito\": \"CPRF\",\n" +
						"    \"numeroCPFCNPJ\": \"string\",\n" +
						"    \"numeroSimulacao\": \"string\",\n" +
						"    \"valorLimite\": 0,\n" +
						"    \"codigoGarantia\": \"string\",\n" +
						"    \"descricaoGarantia\": \"string\",\n" +
						"    \"descricaoTipoPagamento\": \"string\",\n" +
						"    \"prazoTotalSimulacao\": 0,\n" +
						"    \"valorPrincipalSimulacao\": 0,\n" +
						"    \"valorFinalSimulacao\": 0,\n" +
						"    \"taxaIOF\": 0,\n" +
						"    \"taxaIOFAdicional\": 0,\n" +
						"    \"valorIOF\": 0,\n" +
						"    \"valorIOFAdicional\": 0,\n" +
						"    \"taxaCOTX\": 0,\n" +
						"    \"valorJuros\": 0,\n" +
						"    \"datahoraInclusaoSimulacao\": \"2022-08-16T23:32:03.790Z\",\n" +
						"    \"dataVencimentoOperacao\": \"2022-08-16\",\n" +
						"    \"datahoraVigenciaSimulacao\": \"2022-08-16T23:32:03.790Z\",\n" +
						"    \"simulacaoSalva\": true,\n" +
						"    \"instanciaWorkflowBRAIN\": \"string\",\n" +
						"    \"descricaoSimulacaoFormalizacao\": \"string\",\n" +
						"    \"quantidadeParcelasOperacao\": 0,\n" +
						"    \"parcelas\": [\n" +
						"      {\n" +
						"        \"numeroParcela\": 0,\n" +
						"        \"dataVencimentoParcela\": \"2022-08-16\",\n" +
						"        \"valorPrincipalParcela\": 0,\n" +
						"        \"valorJurosParcela\": 0,\n" +
						"        \"quantidadeDiasCorridos\": 0,\n" +
						"        \"quantidadeDiasUteis\": 0\n" +
						"      }\n" +
						"    ]\n" +
						"  },\n" +
						"  \"dadosControleInstituicaoFinanceira\": {\n" +
						"    \"numeroTicketON\": \"string\",\n" +
						"    \"numeroPropostaGCPA\": \"string\",\n" +
						"    \"numeroContratoCorporativo\": \"string\",\n" +
						"    \"instanciaWorkflowBRAIN\": \"string\",\n" +
						"    \"validacaoImovelAgrotools\": [\n" +
						"      {\n" +
						"        \"numeroSequencia\": 0,\n" +
						"        \"numeroCAR\": \"string\",\n" +
						"        \"situacao\": \"string\",\n" +
						"        \"statusRetornoAgrotools\": [\n" +
						"          \"string\"\n" +
						"        ],\n" +
						"        \"numeroProcessID\": 0\n" +
						"      }\n" +
						"    ]\n" +
						"  },\n" +
						"  \"dadosLoteValidador\": {\n" +
						"    \"numeroSequencia\": 0,\n" +
						"    \"numero\": \"string\",\n" +
						"    \"status\": \"string\",\n" +
						"    \"datahoraAberturaLote\": \"2022-08-16T23:32:03.790Z\"\n" +
						"  },\n" +
						"  \"documentos\": [\n" +
						"    {\n" +
						"      \"numeroSequencia\": 0,\n" +
						"      \"tipoDocumental\": \"string\",\n" +
						"      \"situacaoDocumento\": \"string\",\n" +
						"      \"nomeDocumento\": \"string\",\n" +
						"      \"extensaoDocumento\": \"string\",\n" +
						"      \"urlArmazenagem\": \"string\",\n" +
						"      \"datahoraArmazenagem\": \"string\",\n" +
						"      \"numeroLoteValidador\": \"string\",\n" +
						"      \"datahoraEnvioValidador\": \"string\",\n" +
						"      \"datahoraRetornoValidador\": \"string\",\n" +
						"      \"codigoDocumentoValidador\": \"string\",\n" +
						"      \"codigoErroValidador\": \"string\",\n" +
						"      \"descricaoErroValidador\": \"string\",\n" +
						"      \"urlViwerInstituicao\": \"string\",\n" +
						"      \"urlConteudoInstituicao\": \"string\"\n" +
						"    }\n" +
						"  ]" +
						"    }")).process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {

						String body = exchange.getIn().getBody().toString();
						//log.info("body: {}", body);


						ObjectMapper mapper = new ObjectMapper();
						JsonNode json = mapper.readTree(body);

						log.info("json: {}", json);

						log.info("produto: {}", json.get("caracteristicasOperacao").get("produto").asText());
						log.info("caracteristicasVariedade: {}", json.get("caracteristicasOperacao").get("caracteristicasVariedade").asText());
						log.info("simulacaoOrigem: {}", json.get("simulacaoOrigem").get("valorPrincipalSimulacao").asText());


						// array
						log.info("propriedadesRurais: {}", json.get("propriedadesRurais"));
						log.info("propriedadesRurais: {}", json.get("propriedadesRurais").get(0).get("endereco").get("uf").asText());


						String valida = json.get("propriedadesRurais").get(0).get("endereco").get("uf").asText();

						if(json.get("propriedadesRurais").isArray()){
							for( final JsonNode objNode : json.get("propriedadesRurais") ){
									log.info("Arrays: {}", objNode);
								log.info("Arrays: {}", objNode.get("endereco").get("uf").asText());

								if(objNode.get("endereco").get("uf").asText() == valida){
									log.info("AA");
									//exchange.setProperty("valida-endereco", constant(3));
									exchange.setProperty("valida-endereco", constant("aa"));
									exchangeProperty("valida-endereco").append("aa");
									Map<String, Object> mapA = new HashMap<>();
									mapA.put("valida-endereco","iguais");
									exchange.getIn().setHeaders(mapA);
									log.info("Headers: {}", exchange.getIn().getHeaders());


								}



							}
						}

						exchange.getIn().setBody("{\n" +
								"    \"produto\": \"Tomate\",\n" +
								"    \"caracteristicasVariedade\": \"Data Structures and Algorithms in Java\",\n" +
								"    \"simulacaoOrigem\": 500\n" +
								"}");

					}
				})
				.log("${body}")
				.removeHeaders("CamelHttp*")
				.setHeader(Exchange.HTTP_METHOD, constant("PUT"))
				.choice()
					//.when(exchangeProperty("valida-endereco").convertToString().isEqualTo("aa"))
				      .when(header("valida-endereco").convertToString().isEqualTo("iguais"))
						.log("acessou")
					.otherwise()
						.log("não acessou")
				.endChoice();

				//.log("Response code from the operation was: ${header.CamelHttpResponseCode}");


	}
	
}
