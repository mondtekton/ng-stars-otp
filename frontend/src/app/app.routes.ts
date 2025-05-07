import { Routes } from '@angular/router';
import { OtpSendComponent } from './otp/otp-send/otp-send.component';
import { OtpVerifyComponent } from './otp/otp-verify/otp-verify.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { VerifySuccessComponent } from './otp/verify-success/verify-success.component';
import { VerifyFailureComponent } from './otp/verify-failure/verify-failure.component';
import { SendSuccessComponent } from './otp/send-success/send-success.component';

export const routes: Routes = [
  { path: '', redirectTo: 'otp/send', pathMatch: 'full' },
  { path: 'otp/send', component: OtpSendComponent },
  { path: 'otp/verify', component: OtpVerifyComponent },
  { path: 'otp/verify-success', component: VerifySuccessComponent },
  { path: 'otp/verify-failure', component: VerifyFailureComponent },
  { path: 'otp/send-success', component: SendSuccessComponent },
  { path: '**', component: NotfoundComponent },
];
