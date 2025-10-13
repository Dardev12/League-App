//
//  ProfilTopBar.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ProfilTopBar: View {
    @Environment(\.colorScheme) var colorScheme
    @Binding var selection: String?
    let eventClick: () async -> Void
    
    var goHome: () -> Void {
        return {
            selection = "Home"
        }
    }
    
    var signOut: () -> Void {
        return {
            Task {
                await eventClick()
            }
            selection = "AuthMenu"
        }
    }
    
    var goParam: () -> Void {
        return {
            selection = "Parameter"
            AnalyticsManager.manager.logEvent(name: "Click_Parameter_Button")
        }
    }
    
    var body: some View {
        HStack {
            if UIDevice.current.userInterfaceIdiom != .pad {
                IconSizedButton(content: colorScheme == .dark ? \.backicondark : \.backiconlight, condition: goHome)
                Spacer()
                IconButton(content: colorScheme == .dark ? \.gearicondark : \.geariconlight, condition: goParam)
                IconIOSButton(content: "rectangle.portrait.and.arrow.right", condition: signOut)
                
            } else {
                IconIpadButton(content: colorScheme == .dark ? \.backicondark : \.backiconlight, condition: goHome)
                Spacer()
                IconIpadButton(content: colorScheme == .dark ? \.gearicondark : \.geariconlight, condition: goParam)
                IconIOSIpadButton(content: "rectangle.portrait.and.arrow.right", condition: signOut)
            }
        }.padding(.horizontal, 20)
            .padding(.top, 45)
    }
}
