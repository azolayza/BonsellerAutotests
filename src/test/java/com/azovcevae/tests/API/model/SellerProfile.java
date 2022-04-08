package com.azovcevae.tests.API.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class SellerProfile {
        private Integer id;
        private String fullName;
        private String position;
        private double rate;
        private boolean hasCashAccess;
    }

    /*
    {
    "id": 291,
    "fullName": "Потапова Полина",
    "position": "Администратор",
    "rate": 2.320,
    "hasCashAccess": true,
    "shop": {
        "shopId": 47,
        "shopName": "Массажный салон для всех Здоровая спина",
        "address": "Томск, ул. Учебная, 47",
        "logoUrl": "https://l2lt69pxwi.execute-api.eu-central-1.amazonaws.com/dev/downloads/bonpass-files-dev/ShopService-dev%2F9576d3f8-2372-4156-86c8-25ab401d299e?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJCdWNrZXROYW1lIjoiYm9ucGFzcy1maWxlcy1kZXYiLCJGaWxlS2V5IjoiU2hvcFNlcnZpY2UtZGV2Lzk1NzZkM2Y4LTIzNzItNDE1Ni04NmM4LTI1YWI0MDFkMjk5ZSIsIm5iZiI6MTY0Nzg5MDQ3NCwiZXhwIjoxNjQ3ODkwNTA0LCJpc3MiOiJCb25QYXNzLkF1dGhTZXJ2ZXIiLCJhdWQiOiJodHRwczovL2FwaS5ib25wYXNzLmNvbS8ifQ.0rj8nMA7FCdun57BD0p2-u5uJgH9f2hXueQFe76Ijp0"
    },
    "options": {
        "productsEnabled": true,
        "staffMainScreenEnabled": true,
        "cashRegisterEnabled": true,
        "reportsEnabled": true,
        "shouldIdentifyFirst": true,
        "atolIntegrationEnabled": false,
        "showProductsAfterIdentification": true,
        "twoCanIntegrationEnabled": true,
        "turboModeEnabled": true
    },
    "redirectUrl": null
}
     */