package org.itstep.model;

import org.itstep.service.publication.*;


public class LibraryCatalog {
    private PublicationInterface[] items;
    private ShowPublicationInterface show;

    public LibraryCatalog() {
        items = new PublicationInterface[0];
        show = new ShowPublication();
    }

    public void addItem(PublicationInterface item){
        int count = items.length;
        PublicationInterface[] newArr = new PublicationInterface[count];

        for (int i = 0; i < count; i++){
            newArr[i] = items[i];
        }

        items = new PublicationInterface[count+1];

        for (int i = 0; i < count; i++){
            items[i] = newArr[i];
        }

        items[count] = item;
    }

    public void showItems(){
        show.showItems(items);
    }

    public void searchByTitle(String title){
        SearchInterface searchInterface = new SearchByTitle();
        searchInterface.search(items, title);
    }

    public void searchByAuthor(String author){
        SearchInterface searchInterface = new SearchByAuthor();
        searchInterface.search(items, author);
    }
}
