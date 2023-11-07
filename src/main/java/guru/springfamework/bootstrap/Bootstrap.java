package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Class to run app code with CommandLineRunner implementation.
// Saving Data in our Repo.

@Component // Don't forget the BEAN -> Pour qu'elle soit gérée par le conteneur Spring.
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
        loadVendorss();
    }

    private void loadVendorss() {
        Vendor auchan = new Vendor();
        auchan.setName("Auchan");

        Vendor tanneurs = new Vendor();
        tanneurs.setName("Les tanneurs");

        Vendor barn = new Vendor();
        barn.setName("The Barn market");

        vendorRepository.save(auchan);
        vendorRepository.save(tanneurs);
        vendorRepository.save(barn);

        System.out.println("Vendors Loaded = "+vendorRepository.count());

    }

    private void loadCustomers() {
        Customer pierre = new Customer();
        pierre.setFirstname("Pierre");
        pierre.setLastname("Ramon");

        Customer yves = new Customer();
        yves.setFirstname("Yves");
        yves.setLastname("Caplin");

        customerRepository.save(pierre);
        customerRepository.save(yves);

        System.out.println("Customers Loaded = "+customerRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data Loaded = "+categoryRepository.count());
    }
}
