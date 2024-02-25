import java.util.Stack;

/**
 * Client class to create the Stack, Receive and Invoker and to
 * pass in commands for testing.
 */
public class Client {

    /**
     * main method for passing in commands for execution Client class to create the Stack, Receive and Invoker and to
     * pass in commands for testing.
     *
     * @param args to take in argument from command line
     */
    public static void main(String[] args) {

        //Creating the objects
        Stack<Command> cmdStack = new Stack<Command>();
        Receiver cmdReceiver = new Receiver();
        Invoker cmdInvoker = new Invoker();

        //default test from practicum
        //note that the first add command's email address differs from the practicum because the one from the practicum does not match regex
        Command[] test1 = new Command[]
                {
                new AddCommand(cmdReceiver, "First_name Last_name Email@Email.com"),
                new AddCommand(cmdReceiver, "John Doe simple@example.com"),
                new AddCommand(cmdReceiver, "Hanna Moon tetter.tots@potatoesarelife.com"),
                new AddCommand(cmdReceiver, "Ah Boon green-tea@teaforlife.com"),
                new ListCommand(cmdReceiver),
                new UpdateCommand(cmdReceiver, "3 Adam"),
                new ListCommand(cmdReceiver),
                new UpdateCommand(cmdReceiver, "1 blue bell ice-cream@alaskaFields.org"),
                new ListCommand(cmdReceiver),
                new DeleteCommand(cmdReceiver,"1"),
                new ListCommand(cmdReceiver),
                new UndoCommand(cmdReceiver, cmdStack),
                new ListCommand(cmdReceiver)
                };

        //email regex test for add command and update command
        Command[] test2 = new Command[]
                {
                        new AddCommand(cmdReceiver, "First_name Last_name Email@Email.com"),
                        new AddCommand(cmdReceiver, "John Doe simple@example.com"),
                        new AddCommand(cmdReceiver, "Hanna Moon tetter.tots@potatoesarelife.com"),
                        new AddCommand(cmdReceiver, "Ah Boon green-tea@teaforlife.com"),
                        new ListCommand(cmdReceiver),
                        new UpdateCommand(cmdReceiver, "1 blue bell ice-cream@alaskaFields.org"),
                        new UpdateCommand(cmdReceiver, "4 lOVe JAvA LuVjAvA@indonesia.co"),
                        new ListCommand(cmdReceiver),
                        new AddCommand(cmdReceiver, "Ah Huat ________@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat .________@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat _.__.__.__._@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat ________.@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat -________@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat ________-@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat _-__-__-__-_@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat 123________@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat asd________@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat ASD________@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat 123__456__fwgth_tuy_uy@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat asd_SDFg_SDFG___dfhFYU123@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat ASD__ERRG__345__ERTD@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat ________123@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat ________asd@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat ________ASD@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat .@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat -@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat _@teaforlife.com"),  //ok
                        new AddCommand(cmdReceiver, "Ah Huat @teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat 324rSF234SDFuij@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat .23sd4sdfEFRGHJM@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat sdf34f.234sdf.sADF.34rdf.SDF@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat 23sd4sdfEFRGHJM.@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat -23sd4sdfEFRGHJM@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat sdf34f-234sdf-sADF-34rdf.SDF@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat 23sd4sdfEFRGHJM-@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat svb4f-.2976f--sADF.-.34rdf.SDF@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat sdnb.-234786f..sMLIF-.-34rdf.SDF@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@@hello.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@________.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@.________.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@_.__.__.__._.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@________..com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@-________.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@________-.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@_-__-__-__-_.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@123________.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@asd_______.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@ASD________.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@123__456__fwgth_tuy_uy.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@asd_SDFg_SDFG___dfhFYU123.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@ASD__ERRG__345__ERTD.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@.123.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@.asd.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@.ASD.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@-123.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@_asd.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@-ASD.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@..com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@-.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@_.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@324rSF234SDFuij.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@.23sd4sdfEFRGHJM.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@sdf34f.234sdf.sADF.34rdf.SDF.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@23sd4sdfEFRGHJM..com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@-23sd4sdfEFRGHJM.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@sdf34f-234sdf-sADF-34rdf.SDF.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@23sd4sdfEFRGHJM-.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@svb4f-.2976f--sADF.-.34rdf.SDF.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@sdnb.-234786f..sMLIF-.-34rdf.SDF.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife@com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife..com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.-com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife._com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.c"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.3"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.I"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.cI"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.3q"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IV"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.ca"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.33"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.I0"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.c9"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.3B"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.Ia"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.cI9"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.3q6"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IV4"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.ca4"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.331"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.I06"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.c97"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.3B1"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.Ia6"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.cIm"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.3qb"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IVd"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.car"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.33i"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.I03"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.c9c"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.3Bf"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.Iav"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.cIM"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.3qW"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IVV"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.caE"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.33E"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.I0F"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.c9B"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.3BV"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IaX"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IaX4"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IaXd"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IaXN"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IaX-"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IaX_"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.IaX."),
                        new AddCommand(cmdReceiver, "Ah Huat  herbal-tea@teaforlife.com"),   //ok
                        new AddCommand(cmdReceiver, "Ah Huat herbal -tea@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal- tea@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea @teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@ teaforlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teafo rlife.com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife .com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife. com"),
                        new AddCommand(cmdReceiver, "Ah Huat herbal-tea@teaforlife.com "),   //ok
                        new ListCommand(cmdReceiver),
                        new UpdateCommand(cmdReceiver, "5 Hanna Moon ________@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "5 Hanna Moon .________@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "6 Hanna Moon _.__.__.__._@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "6 Hanna Moon ________.@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "6 Hanna Moon -________@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "6 Hanna Moon ________-@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "7 Hanna Moon _-__-__-__-_@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "8 Hanna Moon 123________@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "9 Hanna Moon asd________@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "10 Hanna Moon ASD________@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "11 Hanna Moon 123__456__fwgth_tuy_uy@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "12 Hanna Moon asd_SDFg_SDFG___dfhFYU123@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "13 Hanna Moon ASD__ERRG__345__ERTD@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "14 Hanna Moon ________123@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "15 Hanna Moon ________asd@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "16 Hanna Moon ________ASD@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "16 Hanna Moon .@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "16 Hanna Moon -@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "17 Hanna Moon _@teaforlife.com"),  //ok
                        new UpdateCommand(cmdReceiver, "17 Hanna Moon @teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "18 Hanna Moon 324rSF234SDFuij@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "18 Hanna Moon .23sd4sdfEFRGHJM@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "19 Hanna Moon sdf34f.234sdf.sADF.34rdf.SDF@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "19 Hanna Moon 23sd4sdfEFRGHJM.@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "19 Hanna Moon -23sd4sdfEFRGHJM@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon sdf34f-234sdf-sADF-34rdf.SDF@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon 23sd4sdfEFRGHJM-@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon svb4f-.2976f--sADF.-.34rdf.SDF@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon sdnb.-234786f..sMLIF-.-34rdf.SDF@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@@hello.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@________.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@.________.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@_.__.__.__._.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@________..com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@-________.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@________-.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@_-__-__-__-_.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@123________.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@asd_______.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@ASD________.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@123__456__fwgth_tuy_uy.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@asd_SDFg_SDFG___dfhFYU123.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@ASD__ERRG__345__ERTD.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@.123.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@.asd.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@.ASD.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@-123.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@_asd.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@-ASD.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@..com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@-.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@_.com"),
                        new UpdateCommand(cmdReceiver, "20 Hanna Moon herbal-tea@.com"),
                        new UpdateCommand(cmdReceiver, "21 Hanna Moon herbal-tea@324rSF234SDFuij.com"),   //ok
                        new UpdateCommand(cmdReceiver, "21 Hanna Moon herbal-tea@.23sd4sdfEFRGHJM.com"),
                        new UpdateCommand(cmdReceiver, "22 Hanna Moon herbal-tea@sdf34f.234sdf.sADF.34rdf.SDF.com"),   //ok
                        new UpdateCommand(cmdReceiver, "22 Hanna Moon herbal-tea@23sd4sdfEFRGHJM..com"),
                        new UpdateCommand(cmdReceiver, "22 Hanna Moon herbal-tea@-23sd4sdfEFRGHJM.com"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@sdf34f-234sdf-sADF-34rdf.SDF.com"),   //ok
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@23sd4sdfEFRGHJM-.com"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@svb4f-.2976f--sADF.-.34rdf.SDF.com"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@sdnb.-234786f..sMLIF-.-34rdf.SDF.com"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@teaforlife@com"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@teaforlife..com"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@teaforlife.-com"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@teaforlife._com"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@teaforlife.c"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@teaforlife.3"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@teaforlife.I"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@teaforlife.cI"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@teaforlife.3q"),
                        new UpdateCommand(cmdReceiver, "23 Hanna Moon herbal-tea@teaforlife.IV"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.ca"),   //ok
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.33"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.I0"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.c9"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.3B"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.Ia"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.cI9"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.3q6"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.IV4"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.ca4"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.331"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.I06"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.c97"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.3B1"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.Ia6"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.cIm"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.3qb"),
                        new UpdateCommand(cmdReceiver, "24 Hanna Moon herbal-tea@teaforlife.IVd"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.car"),   //ok
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.33i"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.I03"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.c9c"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.3Bf"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.Iav"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.cIM"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.3qW"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.IVV"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.caE"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.33E"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.I0F"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.c9B"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.3BV"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.IaX"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.IaX4"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.IaXd"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.IaXN"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.IaX-"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.IaX_"),
                        new UpdateCommand(cmdReceiver, "25 Hanna Moon herbal-tea@teaforlife.IaX."),
                        new UpdateCommand(cmdReceiver, "26 Hanna Moon  herbal-tea@teaforlife.com"),   //ok
                        new UpdateCommand(cmdReceiver, "26 Hanna Moon herbal -tea@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "26 Hanna Moon herbal- tea@teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "26 Hanna Moon herbal-tea @teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "26 Hanna Moon herbal-tea@ teaforlife.com"),
                        new UpdateCommand(cmdReceiver, "26 Hanna Moon herbal-tea@teafo rlife.com"),
                        new UpdateCommand(cmdReceiver, "26 Hanna Moon herbal-tea@teaforlife .com"),
                        new UpdateCommand(cmdReceiver, "26 Hanna Moon herbal-tea@teaforlife. com"),
                        new UpdateCommand(cmdReceiver, "27 Hanna Moon herbal-tea@teaforlife.com "),   //ok
                        new ListCommand(cmdReceiver)
                };

        //test for add and undo and list
        Command[] test3 = new Command[]
                {
                        new ListCommand(cmdReceiver),
                        new UndoCommand(cmdReceiver, cmdStack),
                        new AddCommand(cmdReceiver, "First_name Last_name Email@Email.com"),
                        new AddCommand(cmdReceiver, "John Doe simple@example.com"),
                        new AddCommand(cmdReceiver, "Hanna Moon tetter.tots@potatoesarelife.com"),
                        new AddCommand(cmdReceiver, "Ah Boon green-tea@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Adam Lambert SiNgsOng@KaRaOkE.com"),   //ok
                        new AddCommand(cmdReceiver, "    Adam       Lambert       soMANYspaces@KaRaOkE.com      "),   //ok
                        new AddCommand(cmdReceiver, "    aDaM       LaMBErt       soMANYspaces@KaRaOkE.com      "),   //ok
                        new AddCommand(cmdReceiver, ""),
                        new AddCommand(cmdReceiver, "     "),
                        new AddCommand(cmdReceiver, "  Adam   "),
                        new AddCommand(cmdReceiver, "  Rock      Lee "),
                        new AddCommand(cmdReceiver, "    Adam       Lambert       SiNgsOng@KaRaOkE.com   aytuj   "),
                        new AddCommand(cmdReceiver, "    Adam       Lambert       SiNgsOng@KaRaOkE.com   asdf aytuj   "),
                        new ListCommand(cmdReceiver),
                        new UndoCommand(cmdReceiver, cmdStack),
                        new UndoCommand(cmdReceiver, cmdStack),
                        new ListCommand(cmdReceiver),
                };

        //test for delete and undo and list
        Command[] test4 = new Command[]
                {
                        new ListCommand(cmdReceiver),
                        new UndoCommand(cmdReceiver, cmdStack),
                        new DeleteCommand(cmdReceiver,"     0      "),
                        new DeleteCommand(cmdReceiver,"     1      "),
                        new AddCommand(cmdReceiver, "First_name Last_name Email@Email.com"),
                        new AddCommand(cmdReceiver, "John Doe simple@example.com"),
                        new AddCommand(cmdReceiver, "Hanna Moon tetter.tots@potatoesarelife.com"),
                        new AddCommand(cmdReceiver, "Ah Boon green-tea@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Adam Lambert SiNgsOng@KaRaOkE.com"),
                        new AddCommand(cmdReceiver, "Naruto Uzumaki rasengan@rocks.com"),
                        new ListCommand(cmdReceiver),
                        new DeleteCommand(cmdReceiver,"     1      "),   //ok
                        new DeleteCommand(cmdReceiver,"      1"),   //ok
                        new DeleteCommand(cmdReceiver,"1      "),   //ok
                        new DeleteCommand(cmdReceiver,"30"),
                        new DeleteCommand(cmdReceiver,"-1"),
                        new DeleteCommand(cmdReceiver,"0"),
                        new DeleteCommand(cmdReceiver,"2.0"),
                        new DeleteCommand(cmdReceiver,"        30        "),
                        new DeleteCommand(cmdReceiver,"           -1          "),
                        new DeleteCommand(cmdReceiver,"          0         "),
                        new DeleteCommand(cmdReceiver,""),
                        new DeleteCommand(cmdReceiver,"     "),
                        new DeleteCommand(cmdReceiver,"   2   sfg  "),
                        new DeleteCommand(cmdReceiver," 2   lksdf asdasd"),
                        new ListCommand(cmdReceiver),
                        new UndoCommand(cmdReceiver, cmdStack),
                        new UndoCommand(cmdReceiver, cmdStack),
                        new ListCommand(cmdReceiver)
                };

        //test for update and undo and list
        Command[] test5 = new Command[]
                {
                        new ListCommand(cmdReceiver),
                        new UndoCommand(cmdReceiver, cmdStack),
                        new AddCommand(cmdReceiver, "First_name Last_name Email@Email.com"),
                        new AddCommand(cmdReceiver, "John Doe simple@example.com"),
                        new AddCommand(cmdReceiver, "Hanna Moon tetter.tots@potatoesarelife.com"),
                        new AddCommand(cmdReceiver, "Ah Boon green-tea@teaforlife.com"),
                        new AddCommand(cmdReceiver, "Adam Lambert SiNgsOng@KaRaOkE.com"),
                        new AddCommand(cmdReceiver, "Naruto Uzumaki rasengan@rocks.com"),
                        new ListCommand(cmdReceiver),
                        new UpdateCommand(cmdReceiver, ""),
                        new UpdateCommand(cmdReceiver, "    "),
                        new UpdateCommand(cmdReceiver,"     1      "),
                        new UpdateCommand(cmdReceiver,"      1"),
                        new UpdateCommand(cmdReceiver,"1      "),
                        new UpdateCommand(cmdReceiver,"30"),
                        new UpdateCommand(cmdReceiver,"-1"),
                        new UpdateCommand(cmdReceiver,"0"),
                        new UpdateCommand(cmdReceiver,"2.0"),
                        new UpdateCommand(cmdReceiver,"        30        "),
                        new UpdateCommand(cmdReceiver,"           -1          "),
                        new UpdateCommand(cmdReceiver,"          0         "),
                        new UpdateCommand(cmdReceiver,"     1   BlUe   "),   //ok
                        new UpdateCommand(cmdReceiver,"     2   bLue"),   //ok
                        new UpdateCommand(cmdReceiver,"3   yoYOyOYo      "),   //ok
                        new UpdateCommand(cmdReceiver,"30 blue"),
                        new UpdateCommand(cmdReceiver,"-1 blue"),
                        new UpdateCommand(cmdReceiver,"0 blue"),
                        new UpdateCommand(cmdReceiver,"2.0 blue"),
                        new UpdateCommand(cmdReceiver,"        30     blue   "),
                        new UpdateCommand(cmdReceiver,"           -1    blue      "),
                        new UpdateCommand(cmdReceiver,"          0    blue     "),
                        new UpdateCommand(cmdReceiver, "  4    RegeX    saySAYSaY    "),   //ok
                        new UpdateCommand(cmdReceiver, "  5    generics    rocks    my_SOCKS@goingGILA.org"),      //ok
                        new UpdateCommand(cmdReceiver, "  5    asdf     hjlk@asdfasdf.cdd    tynj    sdcw   "),
                        new ListCommand(cmdReceiver),
                        new UndoCommand(cmdReceiver, cmdStack),
                        new ListCommand(cmdReceiver),
                        new UndoCommand(cmdReceiver, cmdStack),
                        new ListCommand(cmdReceiver)
                };

        //Calling methods for testing
        cmdInvoker.setCommandsForExecution(test5);
        cmdInvoker.executeCommand(cmdStack);
        cmdReceiver.storeToFile();

    }
}
