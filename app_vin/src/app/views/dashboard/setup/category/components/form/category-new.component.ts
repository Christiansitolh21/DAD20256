import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators,} from '@angular/forms';

import {abcForms} from '../../../../../../../environments/generals';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatDialogRef} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {Category} from "../../models/category";
import {NgForOf} from "@angular/common";
import {SaleDetail} from "../../../roles/models/SaleDetail";
import {Total} from "../../models/total";

@Component({
    selector: 'app-clients-new',
    standalone: true,
    imports: [
        FormsModule,
        MatIconModule,
        MatButtonModule,
        ReactiveFormsModule,
        MatSlideToggleModule,
        MatFormFieldModule,
        MatInputModule,
        NgForOf,
    ],
    template: `
        <div class="flex flex-col max-w-240 md:min-w-160 max-h-screen -m-6">
            <!-- Header -->
            <div
                class="flex flex-0 items-center justify-between h-16 pr-3 sm:pr-5 pl-6 sm:pl-8 bg-primary text-on-primary">
                <div class="text-lg font-medium">{{ title }}</div>
                <button mat-icon-button (click)="cancelForm()" [tabIndex]="-1">
                    <mat-icon
                        class="text-current"
                        [svgIcon]="'heroicons_outline:x-mark'"
                    ></mat-icon>
                </button>
            </div>


            <!-- Compose form -->
            <form class="flex flex-col flex-auto p-6 sm:p-8 overflow-y-auto" [formGroup]="categoryForm">
                <mat-form-field>
                    <mat-label>Nombre</mat-label>
                    <input matInput formControlName="name"/>
                </mat-form-field>
                <mat-form-field>
                    <mat-label>Descripción</mat-label>
                    <input matInput formControlName="description"/>
                </mat-form-field>
                <mat-form-field>
                    <mat-label>Código</mat-label>
                    <input matInput formControlName="code"/>
                </mat-form-field>
                <mat-form-field>
                    <mat-label>Precio</mat-label>
                    <input matInput formControlName="price"/>
                </mat-form-field>
                <div
                    class="col-sm-9 input-group input-group-sm input-group-rounded"
                >
                    <select
                        class="form-control form-select form-control-sm"
                        formControlName="categoryId"
                    >
                        <option value="" disabled="true">
                            Seleccione Categoria
                        </option>
                        <option
                            *ngFor="let category of categorys"
                            [value]="category.id"
                        >
                            {{ category.name }}
                        </option>
                    </select>
                </div>
                <!-- Actions -->
                <div class="flex flex-col sm:flex-row sm:items-center justify-between mt-4 sm:mt-6">
                    <div class="flex space-x-2 items-center mt-4 sm:mt-0 ml-auto">
                        <button mat-stroked-button [color]="'warn'" (click)="cancelForm()">Cancelar</button>
                        <button mat-stroked-button [color]="'primary'" (click)="saveForm()">
                            Guardar
                        </button>
                    </div>
                </div>


            </form>


            <div class="bg-white rounded overflow-hidden shadow-lg">
                <div class="p-2 overflow-scroll px-0">
                    <table class="w-full table-fixed">
                        <thead class="bg-primary-600 text-white">
                        <tr>
                            <th class="w-1/6 table-head text-center px-5 border-r">#</th>
                            <th class="w-2/6 table-header text-center px-5 border-r">
                                Nombre
                            </th>
                            <th class="w-2/6 table-header text-center px-5 border-r">
                                Base imponible
                            </th>
                            <th class="w-2/6 table-header text-center px-5 border-r">
                                IGV
                            </th>
                            <th class="w-2/6 table-header text-center px-5 border-r">
                                Total
                            </th>
                            <th class="w-2/6 table-header text-center px-5 border-r">
                                Acciones
                            </th>
                        </tr>
                        </thead>
                        <tbody
                            class="bg-white"
                            *ngFor="let r of saleDetails; let i = index">
                        <tr class="hover:bg-gray-100">
                            <td class="w-1/6 p-2 text-center border-b">
                                {{ i }}
                            </td>
                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                {{ r.name }}
                            </td>
                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                {{ r.bi }}
                            </td>
                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                {{ r.igv }}
                            </td>
                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                {{ r.total }}
                            </td>
                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                <button
                                    class="text-sm text-primary-50 transition duration-150 hover:bg-primary-500 bg-primary-600 font-semibold py-2 px-4 rounded-r"
                                    (click)="deleteItem(i)">
                                    Eliminar
                                </button>
                            </td>


                        </tr>

                        </tbody>
                        <tfoot>
                        <tr class="hover:bg-gray-100">

                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                bi
                            </td>
                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                igv
                            </td>
                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                total
                            </td>


                        </tr>
                        <tr class="hover:bg-gray-100">

                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                {{ total.bi }}
                            </td>
                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                {{ total.igv }}
                            </td>
                            <td class="w-2/6 p-2  text-start border-b text-sm">
                                {{ total.total }}
                            </td>


                        </tr>
                        </tfoot>
                    </table>
                    <!--<div class="px-5 py-2 bg-white border-t flex flex-col xs:flex-row items-center xs:justify-between">
                        <span class="text-xs xs:text-sm text-gray-900">
                            Showing 1 to 4 of 50 Entries
                        </span>
                        <div class="inline-flex mt-2 xs:mt-0">
                            <button class="text-sm text-primary-50 transition duration-150 hover:bg-primary-500 bg-primary-600 font-semibold py-2 px-4 rounded-l">
                                Prev
                            </button>
                            &nbsp; &nbsp;
                            <button class="text-sm text-primary-50 transition duration-150 hover:bg-primary-500 bg-primary-600 font-semibold py-2 px-4 rounded-r">
                                Next
                            </button>
                        </div>
                    </div>-->
                </div>
            </div>

        </div>
    `,
})
export class CategoryNewComponent implements OnInit {
    @Input() title: string = '';
    @Input() categorys: Category[] = [];
    public saleDetails: SaleDetail[] = [];
    public total: Total = new Total();

    abcForms: any;
    categoryForm = new FormGroup({
        name: new FormControl('', [Validators.required]),
        description: new FormControl('', [Validators.required]),
        code: new FormControl('', [Validators.required]),
        price: new FormControl(null, [Validators.required]),
        categoryId: new FormControl(null, [Validators.required]),

    });


    constructor(private _matDialog: MatDialogRef<CategoryNewComponent>) {
    }

    ngOnInit() {
        this.abcForms = abcForms;
        this.categoryForm.controls['categoryId'].valueChanges.subscribe((val) => {
            if (val) {

                console.log(this.categoryForm.value.price);

                console.log(typeof (val));
                if (typeof (val) === 'string') {
                    const category = this.categorys.find((c: Category) => c.id === parseInt(val));
                    const saleDetail = new SaleDetail();
                    saleDetail.idCategory = category.id
                    saleDetail.name = category.name;
                    saleDetail.bi = this.categoryForm.value.price;
                    saleDetail.igv = saleDetail.bi * 0.18;
                    saleDetail.total = (parseFloat(String(saleDetail.bi))) + (parseFloat(String(saleDetail.igv)));
                    this.saleDetails.push(saleDetail)
                    this.recall();

                }
            }


        });
    }

    private recall() {
        this.total.total = this.saleDetails.reduce((total, currentValue) => {
            return currentValue.total + total;
        }, 0);
        this.total.igv = this.saleDetails.reduce((total, currentValue) => {
            return currentValue.igv + total;
        }, 0);
        this.total.bi = this.saleDetails.reduce((total, currentValue) => {
            return currentValue.bi + total;
        }, 0);
    }

    public saveForm(): void {
        if (this.categoryForm.valid) {
            this._matDialog.close(this.categoryForm.value);
        }
    }

    public cancelForm(): void {
        this._matDialog.close('');
    }

    public deleteItem(i: number) {
        console.log(i);
        this.saleDetails.splice(i, 1)
        this.recall();
    }
}
