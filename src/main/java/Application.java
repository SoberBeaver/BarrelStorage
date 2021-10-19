import entity.Barrel;
import entity.Beer;
import entity.Whiskey;
import entity.Wine;
import exception.DuplicateLabelException;
import exception.EmptyStorageException;
import service.BarrelStorageService;


public class Application {
    public static void main(String[] args) {

        Barrel barrelWine = new Barrel("Вино из одуванчиков",  new Wine(8), 20);
        Barrel barrelWhiskey = new Barrel("Старый виски", new Whiskey(40), 20);
        Barrel barrelDuffBeer = new Barrel("Пиво Duff", new Beer(4.7), 15);
        Barrel barrelBenderBrauBeer = new Barrel("Пиво BendërBrau", new Beer(5.5), 15);

        BarrelStorageService storageService = new BarrelStorageService();
        try {
            storageService.addBarrel(null);
            storageService.addBarrel(barrelDuffBeer);
            storageService.addBarrel(barrelBenderBrauBeer);
            storageService.addBarrel(barrelWine);
            storageService.addBarrel(barrelWhiskey);
            storageService.addBarrel(barrelWhiskey);
        } catch (DuplicateLabelException e){
            e.printStackTrace();
        }
        System.out.println(storageService);

        storageService.showAllLabels();

        Barrel newBarrel = storageService.getBarrelByLabel("Вино из одуванчиков");
        System.out.println(newBarrel);
        storageService.showAllLabels();

        storageService.clearBarrelStorage();

        try {
            newBarrel = storageService.getBarrelByLabel("Пиво Duff");
            System.out.println(newBarrel);
        } catch (EmptyStorageException e) {
            e.printStackTrace();
        }

        try {
            storageService.showAllLabels();
        } catch (EmptyStorageException e) {
            e.printStackTrace();
        }
    }
}
