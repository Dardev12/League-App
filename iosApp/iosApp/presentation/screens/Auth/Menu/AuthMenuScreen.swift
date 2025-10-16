//
//  AuthMenuScreen.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AuthMenuScreen: View {
    @State private var selection: String? = nil

    
    var body: some View {
        ZStack{
            Color.background
                .ignoresSafeArea()
            VStack{
                NavigationLink(destination: AuthSignInScreen(),tag: "SignIn", selection: $selection){
                    EmptyView()
                }
                NavigationLink(destination: AuthSignUpScreen(),tag: "SignUp", selection: $selection) {
                    EmptyView()
                }
                Image(resource: \.info)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 111.23, height: 135.35)
                Group{
                    AppButton(text:IosStringResources(id:SharedRes.strings().connexion_text_button,args:[]), condition: selectionApplySignIn)
                    
                    AppButton(text:IosStringResources(id:SharedRes.strings().enroll_text_button,args:[]), condition: selectionApplySignUp)
                    
                    CopyrightText()
                }.frame(maxHeight: .infinity,alignment: .bottom)
            }
        }.navigationBarBackButtonHidden(true)
    }
    
    var selectionApplySignIn: () -> Void {
        return {
            selection = "SignIn"
        }
    }
    
    var selectionApplySignUp: () -> Void {
        return {
            selection = "SignUp"
        }
    }
}
