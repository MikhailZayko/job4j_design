package ru.job4j.violation.isp;

/**
 * BasicPrinter вынужден реализовать методы sendFax и scanDocument, которые ему не нужны.
 */

interface Printer {

    void printDocument(String document);

    void sendFax(String document);

    void scanDocument(String document);
}

class BasicPrinter implements Printer {

    @Override
    public void printDocument(String document) {
        System.out.println("Printing document: " + document);
    }

    @Override
    public void sendFax(String document) {
        throw new UnsupportedOperationException("Fax not supported");
    }

    @Override
    public void scanDocument(String document) {
        throw new UnsupportedOperationException("Scan not supported");
    }
}