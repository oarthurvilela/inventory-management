import { Routes } from '@angular/router';
import { ProductComponent } from './product/product.component';
import { AddressComponent } from './address/address.component';
import { CategoryComponent } from './category/category.component';
import { SupplierComponent } from './supplier/supplier.component';

export const routes: Routes = [
    {
        path: 'products',
        component: ProductComponent,
        title: 'Products'
    },
    {
        path: 'categories',
        component: CategoryComponent,
        title: 'Categories'
    },
    {
        path: 'suppliers',
        component: SupplierComponent,
        title: 'Suppliers'
    },
    {
        path: 'addresses',
        component: AddressComponent,
        title: 'Addresses'
    },
];
