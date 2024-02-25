public class Driver {
    public static void main(String[] args) {

        //Valid ContentItem
        ContentItem ci0 = new ContentItem( 0, 5,"Type 0","Hello World 0");
        ContentItem ci0new = new ContentItem( 0, 5,"Type 0","Hello World 0 new");
        ContentItem ci1 = new ContentItem( 1, 10,"Type 1","Hello World 1");
        ContentItem ci1new = new ContentItem( 1, 10,"Type 1","Hello World 1 new");
        ContentItem ci2 = new ContentItem( 2, 20,"Type 2","Hello World 2");
        ContentItem ci2new = new ContentItem( 2, 20,"Type 2","Hello World 2 new");
        ContentItem ci3 = new ContentItem( 3, 40,"Type 3","Hello World 3");
        ContentItem ci3new = new ContentItem( 3, 40,"Type 3","Hello World 3 new");
        ContentItem ci4 = new ContentItem( 4, 80,"Type 4","Hello World 4");
        ContentItem ci4new = new ContentItem( 4, 80,"Type 4","Hello World 4 new");
        ContentItem ci5 = new ContentItem( 5, 100,"Type 5","Hello World 5");
        ContentItem ci5new = new ContentItem( 5, 100,"Type 5","Hello World 5 new");
        ContentItem ci6 = new ContentItem( 6, 120,"Type 6","Hello World 6");
        ContentItem ci6new = new ContentItem( 6, 120,"Type 6","Hello World 6 new");
        ContentItem ci7 = new ContentItem( 7, 140,"Type 7","Hello World 7");
        ContentItem ci7new = new ContentItem( 7, 140,"Type 7","Hello World 7 new");
        ContentItem ci8 = new ContentItem( 8, 160,"Type 8","Hello World 8");
        ContentItem ci8new = new ContentItem( 8, 160,"Type 8","Hello World 8 new");
        ContentItem ci9 = new ContentItem( 9, 180,"Type 9","Hello World 9");
        ContentItem ci9new = new ContentItem( 9, 180,"Type 9","Hello World 9 new");
        ContentItem ci10 = new ContentItem( 10, 200,"Type 10","Hello World 10");
        ContentItem ci10new = new ContentItem( 10, 200,"Type 10","Hello World 10 new");
        ContentItem ci11 = new ContentItem( 11, 220,"Type 11","Hello World 11");
        ContentItem ci11new = new ContentItem( 11, 220,"Type 11","Hello World 11 new");

        //Invalid ContentItem
        ContentItem ciNegativeID = new ContentItem( -1, 100,"Type -1","Hello World -1");
        ContentItem ciZeroSize = new ContentItem( 12, 0,"Type 12","Hello World 12");
        ContentItem ciNegativeSize = new ContentItem( 13, -1,"Type 13","Hello World 13");
        ContentItem ciNullHeader = new ContentItem( 14, 100,null,"Hello World 14");
        ContentItem ciNullContent = new ContentItem( 15, 100,"Type 15",null);

        //DEFAULT CACHE SIZE TEST
        System.out.println("DEFAULT CACHE SIZE TEST");
        Cache cdefault = new Cache();

        //EMPTY CLEAR TEST
        System.out.println("EMPTY CLEAR TEST");
        System.out.println(cdefault.clear());

        //INVALID EVICTION POLICY TEST
        System.out.println("INVALID EVICTION POLICY TEST");
        System.out.println(cdefault.insert(ci0,"aaa"));
        System.out.println(cdefault.insert(ci0,""));
        System.out.println(cdefault.insert(ci0," "));

        //RETRIEVE FROM EMPTY CACHE TEST
        System.out.println("RETRIEVE FROM EMPTY CACHE TEST");
        System.out.println(cdefault.retrieveContent(ci0));

        //UPDATE EMPTY CACHE TEST
        System.out.println("UPDATE EMPTY CACHE TEST");
        System.out.println(cdefault.updateContent(ci0new));

        //LRU INSERTION TEST
        System.out.println("LRU INSERTION TEST");

        System.out.println(cdefault.insert(ci0,"lru"));
        System.out.println(cdefault.insert(ci1,"lru"));
        System.out.println(cdefault.insert(ci2,"lru"));
        System.out.println(cdefault.insert(ci3,"lru"));
        System.out.println(cdefault.insert(ci4,"lru"));
        System.out.println(cdefault.insert(ci5,"lru"));
        System.out.println(cdefault.insert(ci6,"lru"));
        System.out.println(cdefault.insert(ci7,"lru"));
        System.out.println(cdefault.insert(ci8,"lru"));
        System.out.println(cdefault.insert(ci9,"lru"));
        System.out.println(cdefault.insert(ci10,"lru"));
        System.out.println(cdefault.insert(ci11,"lru"));
        System.out.println(cdefault.insert(ciNegativeID,"lru"));
        System.out.println(cdefault.insert(ciZeroSize,"lru"));
        System.out.println(cdefault.insert(ciNegativeSize,"lru"));
        System.out.println(cdefault.insert(ciNullHeader,"lru"));
        System.out.println(cdefault.insert(ciNullContent,"lru"));

        //LRU DUPLICATE INSERTION TEST
        System.out.println("LRU DUPLICATE INSERTION TEST");
        System.out.println(cdefault.insert(ci0,"lru"));
        System.out.println(cdefault.insert(ci1,"lru"));
        System.out.println(cdefault.insert(ci2,"lru"));
        System.out.println(cdefault.insert(ci3,"lru"));
        System.out.println(cdefault.insert(ci4,"lru"));
        System.out.println(cdefault.insert(ci5,"lru"));
        System.out.println(cdefault.insert(ci6,"lru"));
        System.out.println(cdefault.insert(ci7,"lru"));
        System.out.println(cdefault.insert(ci8,"lru"));
        System.out.println(cdefault.insert(ci9,"lru"));
        System.out.println(cdefault.insert(ci10,"lru"));
        System.out.println(cdefault.insert(ci11,"lru"));

        //RETRIEVE FROM CACHE TEST
        System.out.println("RETRIEVE FROM CACHE TEST");
        System.out.println(cdefault.retrieveContent(ci6));
        System.out.println(cdefault.retrieveContent(ci3));
        System.out.println(cdefault.retrieveContent(ci0));
        System.out.println(cdefault.retrieveContent(ci11));
        System.out.println(cdefault.retrieveContent(ciNegativeID));
        System.out.println(cdefault.retrieveContent(ciZeroSize));
        System.out.println(cdefault.retrieveContent(ciNegativeSize));
        System.out.println(cdefault.retrieveContent(ciNullHeader));
        System.out.println(cdefault.retrieveContent(ciNullContent));

        //UPDATE CACHE TEST
        System.out.println("UPDATE CACHE TEST");
        System.out.println(cdefault.updateContent(ci0new));
        System.out.println(cdefault.updateContent(ci3new));
        System.out.println(cdefault.updateContent(ci6new));
        System.out.println(cdefault.updateContent(ci11new));
        System.out.println(cdefault.updateContent(ciNegativeID));
        System.out.println(cdefault.updateContent(ciZeroSize));
        System.out.println(cdefault.updateContent(ciNegativeSize));
        System.out.println(cdefault.updateContent(ciNullHeader));
        System.out.println(cdefault.updateContent(ciNullContent));

        //CLEAR TEST
        System.out.println("CLEAR TEST");
        System.out.println(cdefault.clear());

        //MRU INSERTION TEST
        System.out.println("MRU INSERTION TEST");
        System.out.println(cdefault.insert(ci0,"mru"));
        System.out.println(cdefault.insert(ci1,"mru"));
        System.out.println(cdefault.insert(ci2,"mru"));
        System.out.println(cdefault.insert(ci3,"mru"));
        System.out.println(cdefault.insert(ci4,"mru"));
        System.out.println(cdefault.insert(ci5,"mru"));
        System.out.println(cdefault.insert(ci6,"mru"));
        System.out.println(cdefault.insert(ci7,"mru"));
        System.out.println(cdefault.insert(ci8,"mru"));
        System.out.println(cdefault.insert(ci9,"mru"));
        System.out.println(cdefault.insert(ci10,"mru"));
        System.out.println(cdefault.insert(ci11,"mru"));

        //MRU DUPLICATE INSERTION TEST
        System.out.println("MRU DUPLICATE INSERTION TEST");
        System.out.println(cdefault.insert(ci0,"mru"));
        System.out.println(cdefault.insert(ci1,"mru"));
        System.out.println(cdefault.insert(ci2,"mru"));
        System.out.println(cdefault.insert(ci3,"mru"));
        System.out.println(cdefault.insert(ci4,"mru"));
        System.out.println(cdefault.insert(ci5,"mru"));
        System.out.println(cdefault.insert(ci6,"mru"));
        System.out.println(cdefault.insert(ci7,"mru"));
        System.out.println(cdefault.insert(ci8,"mru"));
        System.out.println(cdefault.insert(ci9,"mru"));
        System.out.println(cdefault.insert(ci10,"mru"));
        System.out.println(cdefault.insert(ci11,"mru"));

        //CLEAR TEST
        System.out.println("CLEAR TEST");
        System.out.println(cdefault.clear());

        //RETRIEVE FROM EMPTY CACHE TEST
        System.out.println("RETRIEVE FROM EMPTY CACHE TEST");
        System.out.println(cdefault.retrieveContent(ci0));

        //UPDATE EMPTY CACHE TEST
        System.out.println("UPDATE EMPTY CACHE TEST");
        System.out.println(cdefault.updateContent(ci0new));


        //"MORE THAN DEFAULT CACHE SIZE TEST"
        System.out.println("MORE THAN DEFAULT CACHE SIZE TEST");
        Cache c4 = new Cache(4);

        //EMPTY CLEAR TEST
        System.out.println("EMPTY CLEAR TEST");
        System.out.println(c4.clear());

        //INVALID EVICTION POLICY TEST
        System.out.println("INVALID EVICTION POLICY TEST");
        System.out.println(c4.insert(ci0,"aaa"));
        System.out.println(c4.insert(ci0,""));
        System.out.println(c4.insert(ci0," "));

        //RETRIEVE FROM EMPTY CACHE TEST
        System.out.println("RETRIEVE FROM EMPTY CACHE TEST");
        System.out.println(c4.retrieveContent(ci0));

        //UPDATE EMPTY CACHE TEST
        System.out.println("UPDATE EMPTY CACHE TEST");
        System.out.println(c4.updateContent(ci0new));

        //LRU INSERTION TEST
        System.out.println("LRU INSERTION TEST");
        System.out.println(c4.insert(ci0,"lru"));
        System.out.println(c4.insert(ci1,"lru"));
        System.out.println(c4.insert(ci2,"lru"));
        System.out.println(c4.insert(ci3,"lru"));
        System.out.println(c4.insert(ci4,"lru"));
        System.out.println(c4.insert(ci5,"lru"));
        System.out.println(c4.insert(ci6,"lru"));
        System.out.println(c4.insert(ci7,"lru"));
        System.out.println(c4.insert(ci8,"lru"));
        System.out.println(c4.insert(ci9,"lru"));
        System.out.println(c4.insert(ci10,"lru"));
        System.out.println(c4.insert(ci11,"lru"));
        System.out.println(c4.insert(ciNegativeID,"lru"));
        System.out.println(c4.insert(ciZeroSize,"lru"));
        System.out.println(c4.insert(ciNegativeSize,"lru"));
        System.out.println(c4.insert(ciNullHeader,"lru"));
        System.out.println(c4.insert(ciNullContent,"lru"));

        //LRU DUPLICATE INSERTION TEST
        System.out.println("LRU DUPLICATE INSERTION TEST");
        System.out.println(c4.insert(ci0,"lru"));
        System.out.println(c4.insert(ci1,"lru"));
        System.out.println(c4.insert(ci2,"lru"));
        System.out.println(c4.insert(ci3,"lru"));
        System.out.println(c4.insert(ci4,"lru"));
        System.out.println(c4.insert(ci5,"lru"));
        System.out.println(c4.insert(ci6,"lru"));
        System.out.println(c4.insert(ci7,"lru"));
        System.out.println(c4.insert(ci8,"lru"));
        System.out.println(c4.insert(ci9,"lru"));
        System.out.println(c4.insert(ci10,"lru"));
        System.out.println(c4.insert(ci11,"lru"));

        //RETRIEVE FROM CACHE TEST
        System.out.println("RETRIEVE FROM CACHE TEST");
        System.out.println(c4.retrieveContent(ci6));
        System.out.println(c4.retrieveContent(ci3));
        System.out.println(c4.retrieveContent(ci0));
        System.out.println(c4.retrieveContent(ci11));
        System.out.println(c4.retrieveContent(ciNegativeID));
        System.out.println(c4.retrieveContent(ciZeroSize));
        System.out.println(c4.retrieveContent(ciNegativeSize));
        System.out.println(c4.retrieveContent(ciNullHeader));
        System.out.println(c4.retrieveContent(ciNullContent));

        //UPDATE CACHE TEST
        System.out.println("UPDATE CACHE TEST");
        System.out.println(c4.updateContent(ci0new));
        System.out.println(c4.updateContent(ci3new));
        System.out.println(c4.updateContent(ci6new));
        System.out.println(c4.updateContent(ci11new));
        System.out.println(c4.retrieveContent(ciNegativeID));
        System.out.println(c4.retrieveContent(ciZeroSize));
        System.out.println(c4.retrieveContent(ciNegativeSize));
        System.out.println(c4.retrieveContent(ciNullHeader));
        System.out.println(c4.retrieveContent(ciNullContent));

        //CLEAR TEST
        System.out.println("CLEAR TEST");
        System.out.println(c4.clear());

        //MRU INSERTION TEST
        System.out.println("MRU INSERTION TEST");
        System.out.println(c4.insert(ci0,"mru"));
        System.out.println(c4.insert(ci1,"mru"));
        System.out.println(c4.insert(ci2,"mru"));
        System.out.println(c4.insert(ci3,"mru"));
        System.out.println(c4.insert(ci4,"mru"));
        System.out.println(c4.insert(ci5,"mru"));
        System.out.println(c4.insert(ci6,"mru"));
        System.out.println(c4.insert(ci7,"mru"));
        System.out.println(c4.insert(ci8,"mru"));
        System.out.println(c4.insert(ci9,"mru"));
        System.out.println(c4.insert(ci10,"mru"));
        System.out.println(c4.insert(ci11,"mru"));

        //MRU DUPLICATE INSERTION TEST
        System.out.println("MRU DUPLICATE INSERTION TEST");
        System.out.println(c4.insert(ci0,"mru"));
        System.out.println(c4.insert(ci1,"mru"));
        System.out.println(c4.insert(ci2,"mru"));
        System.out.println(c4.insert(ci3,"mru"));
        System.out.println(c4.insert(ci4,"mru"));
        System.out.println(c4.insert(ci5,"mru"));
        System.out.println(c4.insert(ci6,"mru"));
        System.out.println(c4.insert(ci7,"mru"));
        System.out.println(c4.insert(ci8,"mru"));
        System.out.println(c4.insert(ci9,"mru"));
        System.out.println(c4.insert(ci10,"mru"));
        System.out.println(c4.insert(ci11,"mru"));

        //CLEAR TEST
        System.out.println("CLEAR TEST");
        System.out.println(c4.clear());

        //RETRIEVE FROM EMPTY CACHE TEST
        System.out.println("RETRIEVE FROM EMPTY CACHE TEST");
        System.out.println(c4.retrieveContent(ci0));

        //UPDATE EMPTY CACHE TEST
        System.out.println("UPDATE EMPTY CACHE TEST");
        System.out.println(c4.updateContent(ci0new));



        //"MINIMUM CACHE SIZE TEST"
        System.out.println("MINIMUM CACHE SIZE TEST");
        Cache c0 = new Cache(0);

        //EMPTY CLEAR TEST
        System.out.println("EMPTY CLEAR TEST");
        System.out.println(c0.clear());

        //INVALID EVICTION POLICY TEST
        System.out.println("INVALID EVICTION POLICY TEST");
        System.out.println(c0.insert(ci0,"aaa"));
        System.out.println(c0.insert(ci0,""));
        System.out.println(c0.insert(ci0," "));

        //RETRIEVE FROM EMPTY CACHE TEST
        System.out.println("RETRIEVE FROM EMPTY CACHE TEST");
        System.out.println(c0.retrieveContent(ci0));

        //UPDATE EMPTY CACHE TEST
        System.out.println("UPDATE EMPTY CACHE TEST");
        System.out.println(c0.updateContent(ci0new));

        //LRU INSERTION TEST
        System.out.println("LRU INSERTION TEST");
        System.out.println(c0.insert(ci0,"lru"));
        System.out.println(c0.insert(ci1,"lru"));
        System.out.println(c0.insert(ci2,"lru"));
        System.out.println(c0.insert(ci3,"lru"));
        System.out.println(c0.insert(ci4,"lru"));
        System.out.println(c0.insert(ci5,"lru"));
        System.out.println(c0.insert(ci6,"lru"));
        System.out.println(c0.insert(ci7,"lru"));
        System.out.println(c0.insert(ci8,"lru"));
        System.out.println(c0.insert(ci9,"lru"));
        System.out.println(c0.insert(ci10,"lru"));
        System.out.println(c0.insert(ci11,"lru"));
        System.out.println(c0.insert(ciNegativeID,"lru"));
        System.out.println(c0.insert(ciZeroSize,"lru"));
        System.out.println(c0.insert(ciNegativeSize,"lru"));
        System.out.println(c0.insert(ciNullHeader,"lru"));
        System.out.println(c0.insert(ciNullContent,"lru"));

        //LRU DUPLICATE INSERTION TEST
        System.out.println("LRU DUPLICATE INSERTION TEST");
        System.out.println(c0.insert(ci0,"lru"));
        System.out.println(c0.insert(ci1,"lru"));
        System.out.println(c0.insert(ci2,"lru"));
        System.out.println(c0.insert(ci3,"lru"));
        System.out.println(c0.insert(ci4,"lru"));
        System.out.println(c0.insert(ci5,"lru"));
        System.out.println(c0.insert(ci6,"lru"));
        System.out.println(c0.insert(ci7,"lru"));
        System.out.println(c0.insert(ci8,"lru"));
        System.out.println(c0.insert(ci9,"lru"));
        System.out.println(c0.insert(ci10,"lru"));
        System.out.println(c0.insert(ci11,"lru"));

        //RETRIEVE FROM CACHE TEST
        System.out.println("RETRIEVE FROM CACHE TEST");
        System.out.println(c0.retrieveContent(ci6));
        System.out.println(c0.retrieveContent(ci3));
        System.out.println(c0.retrieveContent(ci0));
        System.out.println(c0.retrieveContent(ci11));
        System.out.println(c0.retrieveContent(ciNegativeID));
        System.out.println(c0.retrieveContent(ciZeroSize));
        System.out.println(c0.retrieveContent(ciNegativeSize));
        System.out.println(c0.retrieveContent(ciNullHeader));
        System.out.println(c0.retrieveContent(ciNullContent));

        //UPDATE CACHE TEST
        System.out.println("UPDATE CACHE TEST");
        System.out.println(c0.updateContent(ci0new));
        System.out.println(c0.updateContent(ci3new));
        System.out.println(c0.updateContent(ci6new));
        System.out.println(c0.updateContent(ci11new));
        System.out.println(c0.updateContent(ciNegativeID));
        System.out.println(c0.updateContent(ciZeroSize));
        System.out.println(c0.updateContent(ciNegativeSize));
        System.out.println(c0.updateContent(ciNullHeader));
        System.out.println(c0.updateContent(ciNullContent));

        //CLEAR TEST
        System.out.println("CLEAR TEST");
        System.out.println(c0.clear());

        //MRU INSERTION TEST
        System.out.println("MRU INSERTION TEST");
        System.out.println(c0.insert(ci0,"mru"));
        System.out.println(c0.insert(ci1,"mru"));
        System.out.println(c0.insert(ci2,"mru"));
        System.out.println(c0.insert(ci3,"mru"));
        System.out.println(c0.insert(ci4,"mru"));
        System.out.println(c0.insert(ci5,"mru"));
        System.out.println(c0.insert(ci6,"mru"));
        System.out.println(c0.insert(ci7,"mru"));
        System.out.println(c0.insert(ci8,"mru"));
        System.out.println(c0.insert(ci9,"mru"));
        System.out.println(c0.insert(ci10,"mru"));
        System.out.println(c0.insert(ci11,"mru"));

        //MRU DUPLICATE INSERTION TEST
        System.out.println("MRU DUPLICATE INSERTION TEST");
        System.out.println(c0.insert(ci0,"mru"));
        System.out.println(c0.insert(ci1,"mru"));
        System.out.println(c0.insert(ci2,"mru"));
        System.out.println(c0.insert(ci3,"mru"));
        System.out.println(c0.insert(ci4,"mru"));
        System.out.println(c0.insert(ci5,"mru"));
        System.out.println(c0.insert(ci6,"mru"));
        System.out.println(c0.insert(ci7,"mru"));
        System.out.println(c0.insert(ci8,"mru"));
        System.out.println(c0.insert(ci9,"mru"));
        System.out.println(c0.insert(ci10,"mru"));
        System.out.println(c0.insert(ci11,"mru"));

        //CLEAR TEST
        System.out.println("CLEAR TEST");
        System.out.println(c0.clear());

        //RETRIEVE FROM EMPTY CACHE TEST
        System.out.println("RETRIEVE FROM EMPTY CACHE TEST");
        System.out.println(c0.retrieveContent(ci0));

        //UPDATE EMPTY CACHE TEST
        System.out.println("UPDATE EMPTY CACHE TEST");
        System.out.println(c0.updateContent(ci0new));
    }
}