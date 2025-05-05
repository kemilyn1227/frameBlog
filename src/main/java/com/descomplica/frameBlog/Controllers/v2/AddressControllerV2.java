package com.descomplica.frameBlog.Controllers.v2;

import com.descomplica.frameBlog.models.v2.AddressV2;
import com.descomplica.frameBlog.services.v2.AddressServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v2/address")

public class AddressControllerV2 {

    @Autowired
    private AddressServiceV2 addressServiceV2;
    @PostMapping(path = "/save")
    private @ResponseBody AddressV2 save(@RequestBody AddressV2 address) {
        return addressServiceV2.save(address);
    }

    @GetMapping(path = "/getAll")
    private @ResponseBody List<AddressV2> getAll() {
        return addressServiceV2.getAll();
    }

    @GetMapping(path = "/get")
    private @ResponseBody AddressV2 get(@RequestParam final Long id) {
        return addressServiceV2.get(id);
    }

    @PostMapping(path = "/update")
    private @ResponseBody AddressV2 update(@RequestParam final Long id, @RequestBody AddressV2 address) {
        return addressServiceV2.update(id, address);
    }

    @DeleteMapping(path = "/delete")
    private void delete(@RequestParam final Long id) {
        addressServiceV2.delete(id);
    }
}