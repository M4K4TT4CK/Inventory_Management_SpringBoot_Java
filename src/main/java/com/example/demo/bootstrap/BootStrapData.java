package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add parts only if they don't already exist
        addPartIfNotExists("Wheels", 10, 40.0, 100, outsourcedPartRepository);
        addPartIfNotExists("Trucks", 10, 55.0, 101, outsourcedPartRepository);
        addPartIfNotExists("Bearings", 10, 15.0, 102, outsourcedPartRepository);
        addPartIfNotExists("Griptape", 10, 5.0, 103, outsourcedPartRepository);
        addPartIfNotExists("Decks", 10, 65.0, 104, outsourcedPartRepository);

        // Add products only if they don't already exist
        addProductIfNotExists("Skateboard", 100.0, 15, productRepository);
        addProductIfNotExists("Kids Board", 50.0, 10, productRepository);
        addProductIfNotExists("Longboard", 215.0, 10, productRepository);
        addProductIfNotExists("Old School Skateboard", 180.0, 5, productRepository);
        addProductIfNotExists("Electric Skateboard", 500.0, 5, productRepository);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: " + partRepository.count());
        System.out.println(partRepository.findAll());
    }

    private void addPartIfNotExists(String name, int inv, double price, long id, OutsourcedPartRepository repository) {
        boolean partExists = false;
        for (OutsourcedPart existingPart : repository.findAll()) {
            if (existingPart.getName().equals(name)) {
                partExists = true;
                break;
            }
        }

        if (!partExists) {
            OutsourcedPart part = new OutsourcedPart();
            part.setName(name);
            part.setInv(inv);
            part.setPrice(price);
            part.setId(id);
            repository.save(part);
        }
    }

    private void addProductIfNotExists(String name, double price, int inv, ProductRepository repository) {
        boolean productExists = false;
        for (Product existingProduct : repository.findAll()) {
            if (existingProduct.getName().equals(name)) {
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            Product product = new Product(name, price, inv);
            repository.save(product);
        }
    }
}

// Below worked, however everytime the DemoApplication was run, it would add more to the database...the fix is above

//@Component
//public class BootStrapData implements CommandLineRunner {
//
//    private final PartRepository partRepository;
//    private final ProductRepository productRepository;
//
//    private final OutsourcedPartRepository outsourcedPartRepository;
//
//    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
//        this.partRepository = partRepository;
//        this.productRepository = productRepository;
//        this.outsourcedPartRepository=outsourcedPartRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//
//        // Part 1: add wheel parts
//        OutsourcedPart wheels = new OutsourcedPart();
//        wheels.setName("Wheels");
//        wheels.setInv(50);
//        wheels.setPrice(40.0);
//        wheels.setId(100);
//        outsourcedPartRepository.save(wheels);
//        // Part 2: add trucks parts
//        OutsourcedPart trucks = new OutsourcedPart();
//        trucks.setName("Trucks");
//        trucks.setInv(25);
//        trucks.setPrice(55.0);
//        trucks.setId(101);
//        outsourcedPartRepository.save(trucks);
//        // Part 3: add bearings parts
//        OutsourcedPart bearings = new OutsourcedPart();
//        bearings.setName("Bearings");
//        bearings.setInv(200);
//        bearings.setPrice(15.0);
//        bearings.setId(102);
//        outsourcedPartRepository.save(bearings);
//        // Part 4: add griptape parts
//        OutsourcedPart griptape = new OutsourcedPart();
//        griptape.setName("Griptape");
//        griptape.setInv(300);
//        griptape.setPrice(5.0);
//        griptape.setId(103);
//        outsourcedPartRepository.save(griptape);
//        // Part 5: add deck parts
//        OutsourcedPart decks = new OutsourcedPart();
//        decks.setName("Decks");
//        decks.setInv(100);
//        decks.setPrice(65.0);
//        decks.setId(104);
//        outsourcedPartRepository.save(decks);
//
//        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
//        for(OutsourcedPart part:outsourcedParts){
//            System.out.println(part.getName()+" "+part.getCompanyName());
//        }
//
//        // Add 5 products
//        Product skateboard = new Product("Skateboard", 100.0, 15);
//        productRepository.save(skateboard);
//        Product kidsShortBoard = new Product("Kids Board", 50.0, 10);
//        productRepository.save(kidsShortBoard);
//        Product longBoard = new Product("Longboard", 215.0, 10);
//        productRepository.save(longBoard);
//        Product oldSchool = new Product("Old School Skateboard", 180.0, 5);
//        productRepository.save(oldSchool);
//        Product electricSkateboard = new Product("Electric Skateboard", 500.0, 5);
//        productRepository.save(electricSkateboard);
//
//        List<Product> products = (List<Product>) productRepository.findAll();
//        for(Product item: products){
//            System.out.println(item.getName());
//        }
//
//        System.out.println("Started in Bootstrap");
//        System.out.println("Number of Products"+productRepository.count());
//        System.out.println(productRepository.findAll());
//        System.out.println("Number of Parts"+partRepository.count());
//        System.out.println(partRepository.findAll());
//
//    }
//}
