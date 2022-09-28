Feature: PetStore Swager Users

  Scenario: Post user request
    * body icerigini "{'id': 1,++'username': 'zd',++'firstName': 'zeynep',++'lastName': 'dinc',++'email': 'zd@mail.com',++'password': 'String123',++'phone': '05546797494',++'userStatus': 0 ++}" olarak ayarla
    * "domain" "/user" "" urline "post" methoduyla istek at
    * Status kod degerinin 200 oldugunu dogrula


  Scenario: Get user username request
    * body icerigini "{'username': 'zd'}" olarak ayarla
    * "domain" "/user/" "userName" urline "get" methoduyla istek at
    * Status kod degerinin 200 oldugunu dogrula


  Scenario: Get user login request
    * body icerigini "{'username': 'zd',++'password':'String123'}" olarak ayarla
    * "domain" "/user/login" "" urline "get" methoduyla istek at
    * Status kod degerinin 200 oldugunu dogrula


  Scenario: Get user logout request
    * body icerigini "{'username': 'zd',++'password':'String123'}" olarak ayarla
    * "domain" "/user/login" "" urline "get" methoduyla istek at
    * Status kod degerinin 200 oldugunu dogrula
    * "domain" "/user/logout" "" urline "get" methoduyla istek at
    * Status kod degerinin 200 oldugunu dogrula

