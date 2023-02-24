import { NgModule } from "@angular/core";
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';

const components: any [] = [
    MatFormFieldModule, 
    MatToolbarModule,
    MatListModule,
    MatButtonModule,
    MatInputModule,
    MatSelectModule

]

@NgModule({
    imports: components,
    exports: components,
})

export class MaterialModule{}