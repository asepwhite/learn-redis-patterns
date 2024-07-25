from locust import HttpUser, task
import random

class SearchProductUser(HttpUser):
    product_names = [
        "Blouse",
        "Dress",
        "Pants",
        "Jeans",
        "Shorts",
        "Trousers",
        "Sweater",
        "Cardigan",
        "T-shirt",
        "Tank top",
        "Blazer",
        "Coat",
        "Parka",
        "Raincoat",
        "Jumpsuit",
        "Romper",
        "Leggings",
        "Yoga pants",
        "Lingerie",
        "Swimsuit",
        "Bikini",
        "Sarong",
        "Scarf",
        "Hat",
        "Gloves",
        "Belt",
        "Tie",
        "Socks",
        "Shoes",
        "Boots"
    ]

    @task
    def search_product(self):
        product_name = self.product_names[random.randint(0, 29)]
        self.client.get("/products/getByDisplayName?displayName={product_name}".format(product_name = product_name), name="/products/getByDisplayName")