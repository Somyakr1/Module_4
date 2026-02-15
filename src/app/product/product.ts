import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product',
    standalone: true,
  imports: [CommonModule],
  templateUrl: './product.html',
  styleUrl: './product.css',
})
export class Product implements OnInit{
  products: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.productService.getProducts().subscribe({
      next: (data: Product[]) => this.products = data,
      error: (err: any) => console.error('Error fetching products', err)
    });
  }
}
