package com.descomplica.frameBlog.services.v2;

import com.descomplica.frameBlog.models.v2.AddressV2;

import java.util.List;

public interface AddressServiceV2 {
    AddressV2 save (final AddressV2 addressV2);
    List<AddressV2> getAll();

    AddressV2 get(Long id);

    AddressV2 update(Long id, AddressV2 addressV2);

    void delete(Long id);
}


// esta com erro no v2 pois ela ainda não passou esta parte