package co.develhope.repo02.controller;

import co.develhope.repo02.entities.ProgrammingLanguages;
import co.develhope.repo02.repositories.ProgrammingLanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proglang")
public class ProgrammingLanguagesController {
    @Autowired
    private ProgrammingLanguagesRepository programmingLanguageRepository;

    @PostMapping("/create")
    public ProgrammingLanguages create(@RequestBody ProgrammingLanguages programmingLanguage) {
        programmingLanguage.setId(null);
        return programmingLanguageRepository.saveAndFlush(programmingLanguage);
    }

    @GetMapping("/list")
    public List<ProgrammingLanguages> getList(){
        return programmingLanguageRepository.findAll();
    }

    @GetMapping("/page")
    public Page<ProgrammingLanguages> getPagePLList
            (@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        if (page.isPresent() && size.isPresent()) {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "name"), new Sort.Order(Sort.Direction.DESC, "inventor"));
            Pageable pageable = PageRequest.of(page.get(), size.get(), sort);
            return programmingLanguageRepository.findAll(pageable);
        } else {
            return Page.empty();
        }
    }

    @GetMapping("/{id}")
    public ProgrammingLanguages get(@PathVariable Long id){
        Optional<ProgrammingLanguages> pl = programmingLanguageRepository.findById(id);
        return pl.orElse(null);
    }

    @PutMapping("/update/{id}")
    public ProgrammingLanguages updatePLInventor(@PathVariable Long id, @RequestParam(required = false) String inventor) {
        if (programmingLanguageRepository.existsById(id)) {
            ProgrammingLanguages programmingLanguage = programmingLanguageRepository.findById(id).get();
            programmingLanguage.setInventor(inventor);
            return programmingLanguageRepository.saveAndFlush(programmingLanguage);
        } else {
            return new ProgrammingLanguages();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        programmingLanguageRepository.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void delete(){
        programmingLanguageRepository.deleteAll();
    }
}
