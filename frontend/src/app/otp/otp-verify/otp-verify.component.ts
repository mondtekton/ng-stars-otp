import { Component, signal, WritableSignal } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { LoadingComponent } from '../../components/loading/loading.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-otp-verify',
  imports: [ReactiveFormsModule, LoadingComponent],
  templateUrl: './otp-verify.component.html',
})
export class OtpVerifyComponent {
  isLoading: WritableSignal<boolean> = signal(false);

  otpVerifyForm: FormGroup;

  constructor(private router: Router, private fb: FormBuilder) {
    this.otpVerifyForm = fb.group({
      email: ['', [Validators.required, Validators.email]],
      organization: ['', [Validators.required]],
      code: ['', [Validators.required]],
    });
  }

  verifyOtp(): void {
    this.isLoading.set(true);
    setTimeout(() => {
      this.isLoading.set(false);

      // Redirect to success verification page
      let guest: number = Math.floor(Math.random() * (10 - 5)) + 5;

      let redirectUrl: string =
        guest % 2 === 0 ? 'otp/verify-success' : 'otp/verify-failure';

      this.router.navigateByUrl(redirectUrl);
    }, 2000);
  }
}
