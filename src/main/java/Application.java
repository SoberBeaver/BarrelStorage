import entity.Alcohol;
import entity.Beer;
import entity.Whiskey;
import entity.Wine;
import entity.Barrel;
import service.BarrelStorageService;


public class Application {
    public static void main(String[] args) {

        Barrel barrelWine = new Barrel("Вино из одуванчиков",  new Wine(8));
        Barrel barrelWhiskey = new Barrel("Старый виски", new Whiskey(40));
        Barrel barrelDuffBeer = new Barrel("Пиво Duff", new Beer(4.7));
        Barrel barrelBenderBrauBeer = new Barrel("Пиво BendërBrau", new Beer(5.5));

        BarrelStorageService storageService = new BarrelStorageService();
        storageService.addBarrel(null);
        storageService.addBarrel(barrelDuffBeer);
        storageService.addBarrel(barrelBenderBrauBeer);
        storageService.addBarrel(barrelWine);
        storageService.addBarrel(barrelWhiskey);
        System.out.println(storageService);

        storageService.showAllLabels();

        Barrel newBarrel = storageService.getBarrelByLabel("Вино из одуванчиков");
        System.out.println(newBarrel);
        storageService.showAllLabels();

        storageService.clearBarrelStorage();

        storageService.showAllLabels();
    }
}
