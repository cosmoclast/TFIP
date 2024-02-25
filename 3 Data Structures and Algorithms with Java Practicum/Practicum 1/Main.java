public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Benji1", "Allison Thomas", 200);
        Book book2 = new Book("apPle1", "JK Rowling", 1000);
        Book book3 =  new Book("benji2", "Allison Thomas", 200);
        Book book4 = new Book("Apple2", "JK Rowling", 1000);
        Book book5 = new Book("Apple3", "JK Rowling", 1000);
        Book book6 = new Book("Apple4", "JK Rowling", 1000);
        Book book7 = new Book("Apple5", "JK Rowling", 1000);
        Book book8 = new Book("Apple6", "JK Rowling", 1000);
        Book book9 = new Book("Apple7", "JK Rowling", 1000);
        Book book10 = new Book("Apple8", "JK Rowling", 1000);
        Book book11 = new Book("Apple9", "JK Rowling", 1000);
        Book book12 = new Book("Apple9", "JK Rowling", 1000);
        Book book13 =  new Book("Benji3", "Allison Thomas", 200);
        Book book14 =  new Book("Benji4", "Allison Thomas", 200);
        Book book15 =  new Book("Benji5", "Allison Thomas", 200);
        Book book16 =  new Book("Benji6", "Allison Thomas", 200);
        Book book17 =  new Book("Benji7", "Allison Thomas", 200);
        Book book18 =  new Book("Benji8", "Allison Thomas", 200);
        Book book19 =  new Book("Benji9", "Allison Thomas", 200);
        BookManagement manager1 = new BookManagement();
        manager1.add(book1);
        manager1.add(book2);
        manager1.add(book3);
        manager1.add(book4);
        manager1.getArraySize("A");
        manager1.getArraySize("B");
        manager1.add(book5);
        manager1.getArraySize("A");
        manager1.add(book6);
        manager1.add(book7);
        manager1.getArraySize("A");
        manager1.add(book8);
        System.out.println("----------------------------");
        manager1.add(book9);
        manager1.add(book10);
        manager1.add(book11);
        manager1.add(book12);
        manager1.add(book13);
        manager1.add(book14);
        manager1.add(book15);
        manager1.add(book16);
        manager1.add(book17);
        manager1.add(book18);
        manager1.add(book19);
        manager1.display();
        System.out.println("------------------------------------------------");
        manager1.getArraySize("A");
        manager1.getArraySize("B");
        manager1.display();
        manager1.delete("Apple1");
        manager1.getArraySize("A");
        manager1.delete("apple2");
        manager1.getArraySize("A");
        manager1.delete("apple3");
        manager1.getArraySize("A");
        manager1.delete("apple4");
        manager1.getArraySize("A");
        manager1.delete("apple5");
        manager1.delete("apple6");
        manager1.getArraySize("A");
        manager1.delete("apple7");
        manager1.delete("apple8");
        manager1.getArraySize("A");
        manager1.delete("apple9");
        manager1.delete("Benji1");
        manager1.getArraySize("A");
        manager1.getArraySize("B");
        manager1.display();


//        Book a1 = new Book("a1", "Joshua Bloch", 375);
//        Book a2 = new Book("Apple Invasion", "Tim Hill", 200);
//        Book a3 = new Book("Apple Invasion 2", "Tim Hill", 200);
//        Book a4 = new Book("animal farm", "John Doe", 100);
//        Book a5 = new Book("a5", "Joshua Bloch", 375);
//        Book a6 = new Book("atrocious", "Tim Hill", 200);
//        Book a7 = new Book("Andy1", "Tim Hill", 200);
//        Book a8 = new Book("andy2", "John Doe", 100);
//        Book a9 = new Book("antman 3", "Joshua Bloch", 375);
//
//        Book b1 = new Book("Bambi", "Felix Salten", 150);
//        Book b2 = new Book("batman returns", "Alfred Hugh", 350);
//        Book b3 = new Book("batman returns 2", "Alfred Hugh 1", 351);
//        Book b4 = new Book("batman returns 3", "Alfred Hugh 2", 352);
//        Book b5 = new Book("Bambi 1", "Felix Salten", 150);
//        Book b6 = new Book("Bambi 2", "Alfred Hugh", 350);
//        Book b7 = new Book("boy 1", "Alfred Hugh 1", 351);
//        Book b8 = new Book("bOy 2", "Alfred Hugh 2", 352);
//        Book b9 = new Book("Ball 1", "Felix Salten", 150);
//
//        Book c1 = new Book("Fambi", "Felix Salten", 150);
//        Book d1 = new Book("datman returns", "Alfred Hugh", 350);
//        Book e1 = new Book("Eatman returns 2", "Alfred Hugh 1", 351);
//        Book f1 = new Book("Fatman returns 3", "Alfred Hugh 2", 352);
//
//
////        System.out.println(a1);
//
//        BookManagement bm1 = new BookManagement();
//
//        bm1.add(a1);
//        bm1.add(a2);
//        bm1.add(a3);
//        bm1.add(a4);
//        bm1.add(a5);
//        bm1.add(a6);
//        bm1.add(a7);
//        bm1.add(a8);
//        bm1.add(a9);
//        bm1.display();
//        bm1.searchBook("Andy2");
//        bm1.delete("Andy2 ");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));
//
//        bm1.add(b1);
//        bm1.add(b2);
//        bm1.add(b3);
//        bm1.add(b4);
//        bm1.add(b5);
//        bm1.add(b6);
//        bm1.add(b7);
//        bm1.add(b8);
//        bm1.add(b9);
//
//        bm1.add(c1);
//
//        bm1.display();
//        bm1.display("d");
//        bm1.display("d");
//        bm1.display("a");
//        bm1.display("A");
//        bm1.display("b");
//        bm1.display("B");
//
//        System.out.println();
//
//        bm1.delete("a1");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));
//
//        bm1.delete("Apple Invasion");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));
//
//        bm1.add(a1);
//        bm1.display();
//        bm1.searchBook("a1");
//
//        bm1.delete("apple INVASION 2");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));
//
//        bm1.delete("A5");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));
//
//        bm1.delete("animal farm");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));
//
//        bm1.delete("atrocious");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));
//
//        bm1.delete("ANDY1");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));
//
//        bm1.delete("ANDY2");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));
//
//        bm1.delete("a1");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));
//
//        bm1.delete("a1");
//        bm1.delete("a1");
//        bm1.display();
//        System.out.println(bm1.getArraySize("a"));
//        System.out.println(bm1.getArraySize("A"));



//        bm1.searchBook("");

//        System.out.println(bm1.getArraySize("b"));
//        System.out.println(bm1.getArraySize("B"));
//        System.out.println(bm1.getArraySize("d"));
//        System.out.println(bm1.getArraySize("D"));

    }
}