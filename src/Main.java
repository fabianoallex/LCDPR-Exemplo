import sped.core.*;
import sped.lcdpr.v0013.*;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            String xmlFile = "lcdpr/v0013/definitions.xml";
            Definitions definitions = new Definitions(xmlFile, new MyValidation(), "");

            definitions.setFileLoader(fileName -> Objects.requireNonNull(Main.class.getResourceAsStream(fileName)));

            Factory factory = new Factory(definitions);
            LcdprGenerator lcdprGenerator = new LcdprGenerator(factory);

            OpeningRegisterLCDPR openingRegisterLCDPR = lcdprGenerator.getOpeningRegisterLCDPR();
            openingRegisterLCDPR.setNome("Fabiano Alex Arndt");
            openingRegisterLCDPR.setCpf("123.456.789.10");
            openingRegisterLCDPR.setSituacaoInicioPeriodo(OpeningRegisterLCDPR.SituacaoInicioPeriodo.REGULAR);
            openingRegisterLCDPR.setSituacaoEspecial(OpeningRegisterLCDPR.SituacaoEspecial.NORMAL);
            openingRegisterLCDPR.setDataSituacaoEspecial(new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2021"));
            openingRegisterLCDPR.setInicialDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021"));
            openingRegisterLCDPR.setFinalDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021"));

            Block block0 = lcdprGenerator.addBlock("0");
            var r0010 = (Register0010) block0.addNamedRegister(Register0010.class);
            r0010.setFormaApuracao(Register0010.FormaApuracao.LIVRO_CAIXA);

            var r0030 = (Register0030) block0.addNamedRegister(Register0030.class);
            r0030.setBairro("Bairro Luz do Sol");
            r0030.setCep("78.111-222");
            r0030.setEmail("fabiano@alex.com.br");
            r0030.setComplemento("Próximo da praça");
            r0030.setCodigoMunicipio(5558889);
            r0030.setNumero("s/n");
            r0030.setTelefone("65 9 88552233");
            r0030.setUF("MT");
            r0030.setEndereco("Rua da espaço-nave");

            var r0040 = (Register0040) block0.addNamedRegister(Register0040.class);
            r0040.setBairro("Zona Rural");
            r0040.setCodigoImovel(1);
            r0040.setCep("78222-999");
            r0040.setComplemento("Próximo Rio da Enchente");
            r0040.setEndereco("Km 40");
            r0040.setCADITR("123456789");
            r0040.setCAEPF("321654987");
            r0040.setCodigoMunicipio(5599887);
            r0040.setMoeda("BRL");
            r0040.setNomeImovel("Fazenda Boa Sorte");
            r0040.setPais("BR");
            r0040.setNumero("s/n");
            r0040.setParticipacao(100.0);
            r0040.setTipoExploracao(Register0040.TipoExploracao.CONDOMINIO);
            r0040.setUF("MT");

            //r0040.addRegister("0045");
            var r0045 = (Register0045) r0040.addNamedRegister(Register0045.class);

            r0045.setCodigoImovel(1);
            r0045.setCpfCnpj("999.888.777-66");
            r0045.setNome("Pedro da silva");
            r0045.setParticipacao(50.0);
            r0045.setTipoContraparte(Register0045.TipoContraparte.CONDOMINIO);

            r0045 = (Register0045) r0040.addNamedRegister(Register0045.class);
            r0045.setCodigoImovel(2);
            r0045.setCpfCnpj("111.222.333-44");
            r0045.setNome("Juca da silva");
            r0045.setParticipacao(25.0);
            r0045.setTipoContraparte(Register0045.TipoContraparte.CONDOMINIO);

            var blockQ = (BlockQ) lcdprGenerator.addBlock(BlockQ.class);
            var registerQ100 = blockQ.addRegisterQ100();
            registerQ100.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021"));
            registerQ100.setCodigoImovel(1);
            registerQ100.setHistorico("Compra de ração");
            registerQ100.setCpfCnpj("987.654.321-99");
            registerQ100.setTipoDocumento(RegisterQ100.TipoDocumento.NOTA_FISCAL);
            registerQ100.setValorLancamento(125.33, RegisterQ100.TipoLancamento.DESPESA);

            for (int i = 0; i < 10; i++) {
                registerQ100 = blockQ.addRegisterQ100();
                registerQ100.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2021"));
                registerQ100.setCodigoImovel(1);
                registerQ100.setHistorico("Compra de ração 2");
                registerQ100.setCpfCnpj("987.654.321-99");
                registerQ100.setTipoDocumento(RegisterQ100.TipoDocumento.NOTA_FISCAL);
                registerQ100.setValorLancamento(1125.33, RegisterQ100.TipoLancamento.DESPESA);
                registerQ100.setCodigoConta(1);
            }


            registerQ100 = blockQ.addRegisterQ100();
            registerQ100.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("05/02/2021"));
            registerQ100.setCodigoImovel(1);
            registerQ100.setHistorico("Compra de ração 3");
            registerQ100.setCpfCnpj("987.654.321-99");
            registerQ100.setTipoDocumento(RegisterQ100.TipoDocumento.NOTA_FISCAL);
            registerQ100.setValorLancamento(100.20, RegisterQ100.TipoLancamento.DESPESA);

            registerQ100 = blockQ.addRegisterQ100();
            registerQ100.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2021"));
            registerQ100.setCodigoImovel(1);
            registerQ100.setHistorico("Venda de Galinhas");
            registerQ100.setCpfCnpj("987.654.321-99");
            registerQ100.setTipoDocumento(RegisterQ100.TipoDocumento.RECIBO);
            registerQ100.setValorLancamento(5000.0, RegisterQ100.TipoLancamento.RECEITA);

            ClosureRegisterLCDPR closureRegisterLCDPR = lcdprGenerator.getClosureRegisterLCDPR();

            closureRegisterLCDPR.setCpfCnpjContador("123456789101");
            closureRegisterLCDPR.setCrcContador("9988776655");
            closureRegisterLCDPR.setNomeContador("joao da silva");
            closureRegisterLCDPR.setEmailContador("  joao.silva@contador.com.br");
            closureRegisterLCDPR.setFoneContador("65 9 9988 7766");

            blockQ.calculateBalances();
            blockQ.generateQ200();

            lcdprGenerator.totalize();
            lcdprGenerator.write((string, register) -> System.out.println(register));

            lcdprGenerator.validate(new ValidationListener() {
                @Override
                public void onSuccessMessage(ValidationEvent validationEvent) {
                    System.out.println(validationEvent.getMessage());
                }

                @Override
                public void onWarningMessage(ValidationEvent validationEvent) {
                    System.out.println(validationEvent.getMessage());
                }

                @Override
                public void onErrorMessage(ValidationEvent validationEvent) {
                    System.out.println(validationEvent.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}