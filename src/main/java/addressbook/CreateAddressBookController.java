package addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAddressBookController {

    private AddressBook book;
    private AddressBookRepository repo;

    @Autowired
    public CreateAddressBookController(AddressBookRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("book", new AddressBook());
        return "createBook";
    }

    @PostMapping("/new")
    public String greetingSubmit(@ModelAttribute AddressBook book) {
        return "newBook";
    }

    @RequestMapping(value = "/book/find")
    public AddressBook findBook(@RequestParam(value = "id") int id ) {
        book = repo.findById(id);
        return book;
    }

    @RequestMapping(value = "/book")
    public AddressBook createBook(@RequestParam(value = "owner", defaultValue = "Default") String owner) {
        book = new AddressBook(owner);
        repo.save(book);
        return book;
    }

    @RequestMapping(value = "/book/add")
    public AddressBook addBuddy(@RequestParam(value = "name") String name, @RequestParam(value = "address") String address, @RequestParam(value = "number") String number) {
        if (book == null)
            book = new AddressBook();
        BuddyInfo b = new BuddyInfo(name, address, number);
        book.addBuddy(b);
        repo.save(book);
        return book;
    }

    @RequestMapping(value = "/book/remove")
    public AddressBook removeBuddy(@RequestParam(value = "index") int index) {
        book.removeBuddyIndex(index);
        repo.save(book);
        return book;
    }
}
