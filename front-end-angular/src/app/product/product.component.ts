import { CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatTooltipModule } from '@angular/material/tooltip';
import { RouterModule } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faEdit, faPlusCircle, faTrash } from '@fortawesome/free-solid-svg-icons';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [CommonModule, RouterModule, MatButtonModule, MatTableModule, MatPaginatorModule, FontAwesomeModule, MatButtonModule, MatTooltipModule],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {
  title: string = 'Products';
  faPlusCircle = faPlusCircle;
  faEdit = faEdit;
  faTrash = faTrash;
  productList!: Product[];
  dataSource: any;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.fetchProducts();
  }

  fetchProducts() {
    this.productService.getAllProducts().subscribe(data => {
      this.productList = data;
      this.dataSource = new MatTableDataSource(this.productList);
      this.dataSource.paginator = this.paginator;
    })
  }
  displayedColumns: string[] = ['ID', 'Name', 'Price', 'Quantity', 'Category', 'Supplier', 'Actions'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
}